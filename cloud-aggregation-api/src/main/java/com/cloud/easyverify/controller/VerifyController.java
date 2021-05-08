package com.cloud.easyverify.controller;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.cloud.easyverify.feign.SecretFeignService;
import com.cloud.easyverify.feign.TemplateFeignService;
import com.cloud.easyverify.feign.VerifyFeignService;
import com.cloud.easyverify.result.MyResult;
import com.cloud.easyverify.result.ResultMsg;
import com.cloud.easyverify.util.Util;
import com.cloud.easyverify.util.YunCourierUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.*;
import java.util.Date;

/**
 * @PackageName: com.cloud.easyverify.controller
 * @ClassName: VerifyController
 * @Description: This is VerifyController class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 23:45
 */
@CrossOrigin
@RestController
@RequestMapping("/v1/api/public/verify")
@Validated
public class VerifyController {
    @Autowired
    private VerifyFeignService verifyFeignService;
    @Autowired
    private SecretFeignService secretFeignService;
    @Autowired
    private TemplateFeignService templateFeignService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping("/create")
    public MyResult create(@NotEmpty String secret, long tid, @Email @NotEmpty String email, @NotNull String remark) {
        MyResult result = secretFeignService.getBySecret(secret);
        if (result.getCode() == 200) {
            JSONObject jsonObject = JSONUtil.parseObj(result.getData());
            if (jsonObject.getInt("state") == 1) {
                if (jsonObject.getDate("expireTime").after(new Date())) {
                    long uid = jsonObject.getInt("uid");
                    long sid = jsonObject.getInt("id");
                    result = templateFeignService.selectOne(tid, uid);
                    if (result.getCode() == 200) {
                        jsonObject = JSONUtil.parseObj(result.getData());
                        if (jsonObject.getInt("state") == 1) {
                            int tryTotal = jsonObject.getInt("tryTotal");
                            String ip = ServletUtil.getClientIP(httpServletRequest);
                            System.out.println(result.toString());
                            int codeType = jsonObject.getInt("codeType");
                            int codeLen = jsonObject.getInt("codeLen");
                            String code = Util.getCode(codeType, codeLen);
                            String title = jsonObject.getStr("title");
                            String content = jsonObject.getStr("content").replaceAll("\\$\\(#code\\)", code);
                            int validTime = jsonObject.getInt("validTime");
                            Date expireTime = DateUtil.date(System.currentTimeMillis());
                            expireTime = DateUtil.offset(expireTime, DateField.SECOND, validTime).toJdkDate();
                            expireTime = DateUtil.offsetHour(expireTime, -14).toJdkDate();
                            int state = 1;
                            if (!YunCourierUtil.sendEmail(email, title, content)) {
                                state = 2;
                            }
                            result = verifyFeignService.create(uid, sid, tid, 1, state, tryTotal, ip, code, email, title, content, expireTime, remark);
                            if (result.getCode() == 200) {
                                if (state == 1) {
                                    return new MyResult(ResultMsg.SUCCESS, result.getData());
                                } else {
                                    return new MyResult(ResultMsg.API_SENDFAIL);
                                }
                            } else {
                                return new MyResult(ResultMsg.API_SYSTEMBUSY);
                            }
                        } else {
                            return new MyResult(ResultMsg.API_TEMPLATESTATEEERROR);
                        }
                    } else {
                        return new MyResult(ResultMsg.API_TEMPLATEERROR);
                    }
                } else {
                    return new MyResult(ResultMsg.API_SECRETEXPIRED);
                }
            } else {
                return new MyResult(ResultMsg.API_SECRETINVALID);
            }
        } else {
            return new MyResult(ResultMsg.API_SECRETINVALID);
        }
    }


    @RequestMapping("/check")
    public MyResult check(@NotEmpty String uuid, String email, @NotEmpty String code) {
        MyResult result = verifyFeignService.getByUUId(uuid);
        if (result.getCode() == 200) {
            JSONObject jsonObject = JSONUtil.parseObj(result.getData());
            if (jsonObject.getInt("state") == 1 && jsonObject.getDate("expireTime").after(new Date()) && jsonObject.getInt("tryTotal") > jsonObject.getInt("tryCount")) {
                int state = 0;
                if (code.equals(jsonObject.getStr("code")) && ("".equals(email) || jsonObject.getStr("email").equals(email))) {
                    state = 3;
                }
                if (verifyFeignService.modifyByUUId(uuid, state, 1).getCode() == 200) {
                    if (state == 3) {
                        return new MyResult(ResultMsg.SUCCESS);
                    } else {
                        return new MyResult(ResultMsg.API_CODEERROR);
                    }
                } else {
                    return new MyResult(ResultMsg.API_SYSTEMBUSY);
                }
            } else {
                return new MyResult(ResultMsg.API_VERIFYEXPIRED);
            }
        } else {
            return new MyResult(ResultMsg.API_UUIDERROR);
        }
    }

    @RequestMapping("/getInfo")
    public MyResult getInfo(@NotEmpty String uuid) {
        MyResult result = verifyFeignService.getByUUId(uuid);
        if (result.getCode() == 200) {
            return new MyResult(ResultMsg.SUCCESS, result.getData());
        } else {
            return new MyResult(ResultMsg.API_UUIDERROR);
        }
    }

    @RequestMapping("/changeState")
    public MyResult changeState(@NotEmpty String uuid, @Min(1) @Max(2) int state) {
        MyResult result = verifyFeignService.modifyByUUId(uuid, state, 0);
        if (result.getCode() == 200) {
            return new MyResult(ResultMsg.SUCCESS);
        } else {
            return new MyResult(ResultMsg.API_UUIDERROR);
        }
    }
}
