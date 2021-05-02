package com.cloud.easyverify.controller;

import com.cloud.easyverify.entity.User;
import com.cloud.easyverify.result.MyResult;
import com.cloud.easyverify.result.ResultMsg;
import com.cloud.easyverify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
}
