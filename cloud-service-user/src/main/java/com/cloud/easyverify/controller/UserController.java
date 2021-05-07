package com.cloud.easyverify.controller;


import com.cloud.easyverify.annotation.PassToken;
import com.cloud.easyverify.annotation.UserToken;
import com.cloud.easyverify.entity.Token;
import com.cloud.easyverify.entity.User;
import com.cloud.easyverify.result.MyResult;
import com.cloud.easyverify.result.ResultMsg;
import com.cloud.easyverify.service.UserService;
import com.cloud.easyverify.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
 * @Date: 2021-05-02 19:49
 */
@RestController
@RequestMapping("/v1/api/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenUtil tokenUtil;

    @PassToken
    @RequestMapping("/register")
    public MyResult register(@NotEmpty String username, @NotEmpty String password) {
        User user = new User();
        user.setUsername(username);
        int count = userService.getCount(user);
        if (count > 0) {
            return new MyResult(ResultMsg.USER_EXISTED);
        }
        user.setType(1);
        user.setState(1);
        user.setAuthorization("");
        user.setRemark("");
        user.setPassword(password);
        count = userService.insertOne(user);
        if (count > 0) {
            return new MyResult(ResultMsg.SUCCESS);
        } else {
            return new MyResult(ResultMsg.USER_REGISTERFAIL);
        }
    }

    @PassToken
    @RequestMapping("/login")
    public MyResult login(@NotEmpty String username, @NotEmpty String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user = userService.selectOne(user);
        if (user != null) {
            if (user.getState() == 1) {
                Map<String, Object> map = new HashMap<>();
                String token = tokenUtil.createToken(user);
                map.put("token", token);
                user.setAuthorization(token);
                int count = userService.updateOne(user);
                if (count>0){
                    return new MyResult(ResultMsg.SUCCESS, map);
                }else{
                    return new MyResult(ResultMsg.USER_LOGINFAIL);
                }
            } else {
                return new MyResult(ResultMsg.USER_LIMITLOGIN);
            }
        } else {
            return new MyResult(ResultMsg.USER_LOGINFAIL);
        }
    }

    @UserToken
    @RequestMapping("/getUserInfo")
    public MyResult getUserInfo(@RequestHeader("Authorization") String authorization) {
        Token token = tokenUtil.parseToken(authorization);
        if (token != null) {
            User user = new User();
            user.setId(token.getId());
            user = userService.getById(user);
            if (user != null) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", user.getId());
                map.put("type", user.getType());
                map.put("state", user.getState());
                map.put("username", user.getUsername());
                map.put("addTime", user.getAddTime());
                return new MyResult(ResultMsg.SUCCESS, map);
            } else {
                return new MyResult(ResultMsg.USER_USERNOTEXIST);
            }
        } else {
            return new MyResult(ResultMsg.USER_ACCESSERROR);
        }
    }
}
