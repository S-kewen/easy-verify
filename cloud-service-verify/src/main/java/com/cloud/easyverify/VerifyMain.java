package com.cloud.easyverify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PackageName: com.cloud.easyverify
 * @ClassName: VerifyMain
 * @Description: This is VerifyMain class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 10:32
 */
@SpringBootApplication
@EnableDiscoveryClient
public class VerifyMain {
    public static void main(String[] args) {
        SpringApplication.run(VerifyMain.class, args);
        System.out.println("VerifyMain-启动完毕!!!");
    }
}
