package com.cloud.easyverify.controller;

import com.cloud.easyverify.annotation.PassToken;
import com.cloud.easyverify.annotation.UserToken;
import com.cloud.easyverify.entity.Token;
import com.cloud.easyverify.entity.User;
import com.cloud.easyverify.feign.SecretFeignService;
import com.cloud.easyverify.feign.UserFeignService;
import com.cloud.easyverify.result.MyResult;
import com.cloud.easyverify.result.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName: com.cloud.easyverify.controller
 * @ClassName: UserController
 * @Description: This is UserController class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 14:50
 */
@CrossOrigin
@RestController
@RequestMapping("/v1/api/h5/user")
@Validated
public class UserController {
    @Autowired
    private UserFeignService userFeignService;

    @PassToken
    @RequestMapping("/register")
    public MyResult register(@NotEmpty String username, @NotEmpty String password) {
       return userFeignService.register(username,password);
    }

    @PassToken
    @RequestMapping("/login")
    public MyResult login(@NotEmpty String username, @NotEmpty String password) {
        return userFeignService.login(username,password);
    }

    @UserToken
    @RequestMapping("/getUserInfo")
    public MyResult getUserInfo(@RequestHeader("Authorization") String authorization) {
        return userFeignService.getUserInfo(authorization);
    }
}
