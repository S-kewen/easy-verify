package com.cloud.easyverify.controller;

import cn.hutool.core.util.IdUtil;
import com.cloud.easyverify.entity.Secret;
import com.cloud.easyverify.entity.Token;
import com.cloud.easyverify.entity.Verify;
import com.cloud.easyverify.result.MyResult;
import com.cloud.easyverify.result.ResultMsg;
import com.cloud.easyverify.service.VerifyService;
import com.cloud.easyverify.util.TokenUtil;
import com.cloud.easyverify.util.Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.easyverify.controller
 * @ClassName: VerifyController
 * @Description: This is VerifyController class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 9:59
 */
@RestController
@RequestMapping("/v1/api/verify")
@Validated
public class VerifyController {
    @Autowired
    private VerifyService verifyService;
    @Autowired
    private TokenUtil tokenUtil;

    @RequestMapping("/create")
    public MyResult create(long uid, long sid, long tid, int type, int state, int tryTotal, @NotNull String ip, @NotNull String code, @NotNull @Email String email, @NotNull String title, @NotNull String content, @NotNull Date expireTime, @NotNull String remark) {
        Verify verify = new Verify();
        verify.setUuid(IdUtil.simpleUUID());
        verify.setUid(uid);
        verify.setSid(sid);
        verify.setTid(tid);
        verify.setType(type);
        verify.setState(state);
        verify.setTryCount(0);
        verify.setTryTotal(tryTotal);
        verify.setIp(ip);
        verify.setCode(code);
        verify.setEmail(email);
        verify.setTitle(title);
        verify.setContent(content);
        verify.setRemark(remark);
        verify.setExpireTime(expireTime);
        int count = verifyService.insertOne(verify);
        if (count > 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", verify.getId());
            map.put("uuid", verify.getUuid());
            return new MyResult(ResultMsg.SUCCESS, map);
        } else {
            return new MyResult(ResultMsg.VERIFY_CREATEFAIL);
        }
    }

    @RequestMapping("/listVerify")
    public MyResult listVerify(@RequestHeader("Authorization") String authorization, int page, @Max(1000) int size, String keyword, int type, int state, String sortName, String sortType) {
        Token token = tokenUtil.parseToken(authorization);
        if (token != null) {
            Verify verify = new Verify();
            verify.setUid(token.getId());
            verify.setType(type);
            verify.setState(state);
            verify.setCode(keyword);
            PageHelper.startPage(page, size, Util.sort(sortName, sortType));
            List<Map<String, Object>> list = verifyService.list(verify);
            PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
            return new MyResult(ResultMsg.SUCCESS, pageInfo);
        } else {
            return new MyResult(ResultMsg.USER_ACCESSERROR);
        }
    }

    @RequestMapping("/delete")
    public MyResult delete(@RequestHeader("Authorization") String authorization, @Min(1) int id) {
        Token token = tokenUtil.parseToken(authorization);
        if (token != null) {
            Verify verify = new Verify();
            verify.setId(id);
            verify.setUid(token.getId());
            int count = verifyService.deleteOne(verify);
            if (count > 0) {
                return new MyResult(ResultMsg.SUCCESS);
            } else {
                return new MyResult(ResultMsg.VERIFY_DELETEFAIL);
            }
        } else {
            return new MyResult(ResultMsg.USER_ACCESSERROR);
        }
    }

    @RequestMapping("/changeState")
    public MyResult changeState(@RequestHeader("Authorization") String authorization, @Min(1) int id, int state) {
        Token token = tokenUtil.parseToken(authorization);
        if (token != null) {
            Verify verify = new Verify();
            verify.setId(id);
            verify.setUid(token.getId());
            verify.setState(state);
            int count = verifyService.updateOne(verify);
            if (count > 0) {
                return new MyResult(ResultMsg.SUCCESS);
            } else {
                return new MyResult(ResultMsg.VERIFY_UPDATEFAIL);
            }
        } else {
            return new MyResult(ResultMsg.USER_ACCESSERROR);
        }
    }
}
