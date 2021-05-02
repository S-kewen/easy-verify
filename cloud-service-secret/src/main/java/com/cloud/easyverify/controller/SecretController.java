package com.cloud.easyverify.controller;

import cn.hutool.core.util.RandomUtil;
import com.cloud.easyverify.entity.Secret;
import com.cloud.easyverify.entity.Token;
import com.cloud.easyverify.result.MyResult;
import com.cloud.easyverify.result.ResultMsg;
import com.cloud.easyverify.service.SecretService;
import com.cloud.easyverify.util.TokenUtil;
import com.cloud.easyverify.util.Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.easyverify.controller
 * @ClassName: SecretController
 * @Description: This is SecretController class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-02 21:34
 */
@RestController
@RequestMapping("/v1/api/secret")
@Validated
public class SecretController {
    @Autowired
    private SecretService secretService;
    @Autowired
    private TokenUtil tokenUtil;

    @RequestMapping("/create")
    public MyResult create(@RequestHeader("Authorization") String authorization,Date expireTime, @NotNull String remark) {
        Token token = tokenUtil.parseToken(authorization);
        if (token != null) {
            Secret secret = new Secret();
            secret.setUid(token.getId());
            secret.setType(1);
            secret.setState(1);
            secret.setSecret(RandomUtil.randomString(32));
            secret.setExpireTime(expireTime);
            secret.setRemark(remark);
            int count = secretService.insertOne(secret);
            if (count > 0) {
                return new MyResult(ResultMsg.SUCCESS, secret.getSecret());
            } else {
                return new MyResult(ResultMsg.SECRET_CREATEFAIL);
            }
        } else {
            return new MyResult(ResultMsg.USER_ACCESSERROR);
        }
    }

    @RequestMapping("/listSecret")
    public MyResult listSecret(@RequestHeader("Authorization") String authorization, int page, @Max(1000) int size, String keyword, int type, int state, String sortName, String sortType) {
        Token token = tokenUtil.parseToken(authorization);
        if (token != null) {
            Secret secret = new Secret();
            secret.setUid(token.getId());
            secret.setType(type);
            secret.setState(state);
            secret.setSecret(keyword);
            PageHelper.startPage(page, size, Util.sort(sortName, sortType));
            List<Map<String, Object>> list = secretService.list(secret);
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
            Secret secret = new Secret();
            secret.setId(id);
            secret.setUid(token.getId());
            int count = secretService.deleteOne(secret);
            if (count > 0) {
                return new MyResult(ResultMsg.SUCCESS);
            } else {
                return new MyResult(ResultMsg.SECRET_DELETEFAIL);
            }
        } else {
            return new MyResult(ResultMsg.USER_ACCESSERROR);
        }
    }

    @RequestMapping("/modify")
    public MyResult modify(@RequestHeader("Authorization") String authorization, @Min(1) int id,Date expireTime, @NotNull String remark) {
        Token token = tokenUtil.parseToken(authorization);
        if (token != null) {
            Secret secret = new Secret();
            secret.setId(id);
            secret.setUid(token.getId());
            secret.setExpireTime(expireTime);
            secret.setRemark(remark);
            int count = secretService.updateOne(secret);
            if (count > 0) {
                return new MyResult(ResultMsg.SUCCESS);
            } else {
                return new MyResult(ResultMsg.SECRET_UPDATEFAIL);
            }
        } else {
            return new MyResult(ResultMsg.USER_ACCESSERROR);
        }
    }
}
