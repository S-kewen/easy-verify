package com.cloud.easyverify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PackageName: com.cloud.easyverify
 * @ClassName: TemplateMain
 * @Description: This is TemplateMain class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-04 18:19
 */
@SpringBootApplication
@EnableDiscoveryClient
public class TemplateMain {
    public static void main(String[] args) {
        SpringApplication.run(TemplateMain.class, args);
        System.out.println("TemplateMain-启动完毕!!!");
    }
}
