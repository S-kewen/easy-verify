package com.cloud.easyverify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @PackageName: com.cloud.easyverify
 * @ClassName: SecretMain
 * @Description: This is SecretMain class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-02 23:14
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SecretMain {
    public static void main(String[] args) {
        SpringApplication.run(SecretMain.class, args);
        System.out.println("SecretMain-启动完毕!!!");
    }
}
