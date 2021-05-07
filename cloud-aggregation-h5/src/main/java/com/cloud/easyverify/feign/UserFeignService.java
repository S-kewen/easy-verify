package com.cloud.easyverify.feign;

import com.cloud.easyverify.result.MyResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @PackageName: com.cloud.easyverify.feign
 * @ClassName: UserFeignService
 * @Description: This is UserFeignService interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 14:48
 */
@Component
@FeignClient(value = "cloud-service-user")
public interface UserFeignService {
    String URL = "/v1/api/user";

    @RequestMapping(URL + "/register")
    public MyResult register(@RequestParam("username") String username, @RequestParam("password") String password);

    @RequestMapping(URL + "/login")
    public MyResult login(@RequestParam("username") String username, @RequestParam("password") String password);

    @RequestMapping(URL + "/getUserInfo")
    public MyResult getUserInfo(@RequestHeader("Authorization") String authorization);


}
