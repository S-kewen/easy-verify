package com.cloud.easyverify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PackageName: com.cloud.easyverify
 * @ClassName: ApiGatewayMain
 * @Description: This is ApiGatewayMain class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-08 23:33
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ApiGatewayMain {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayMain.class, args);
        System.out.println("ApiGatewayMain-启动完毕!");
    }
}
