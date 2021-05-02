package com.cloud.easyverify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @PackageName: com.cloud.easyverify
 * @ClassName: UserMain
 * @Description: This is UserMain class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-02 19:15
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserMain {
    public static void main(String[] args) {
        SpringApplication.run(UserMain.class, args);
        System.out.println("UserMain-启动完毕!!!");
    }
}
