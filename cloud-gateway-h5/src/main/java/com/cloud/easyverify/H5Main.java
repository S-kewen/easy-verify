package com.cloud.easyverify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PackageName: com.cloud.easyverify
 * @ClassName: H5Main
 * @Description: This is H5Main class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 16:30
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class H5Main {
    public static void main(String[] args) {
        SpringApplication.run(H5Main.class, args);
        System.out.println("H5Main-启动完毕!");
    }
}
