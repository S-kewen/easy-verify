package com.cloud.easyverify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @PackageName: com.cloud.easyverify
 * @ClassName: ApiMain
 * @Description: This is ApiMain class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 23:39
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
@EnableDiscoveryClient
public class ApiMain {
    public static void main(String[] args) {
        SpringApplication.run(ApiMain.class, args);
        System.out.println("ApiMain-启动完毕!");
    }
}
