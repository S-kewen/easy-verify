package com.cloud.easyverify;

import com.cloud.easyverify.config.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @PackageName: com.cloud.easyverify
 * @ClassName: H5Main
 * @Description: This is H5Main class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 11:22
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.cloud.easyverify",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = RandomRule.class)
})
public class H5Main {
    public static void main(String[] args) {
        SpringApplication.run(H5Main.class, args);
        System.out.println("H5Main-启动完毕!");
    }
}
