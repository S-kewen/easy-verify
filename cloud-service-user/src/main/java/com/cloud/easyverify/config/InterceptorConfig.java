package com.cloud.easyverify.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @PackageName: com.cloud.easyverify.config
 * @ClassName: InterceptorConfig
 * @Description: This is InterceptorConfig class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-02 21:09
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/v1/api/**");
    }

    @Bean
    @Order(2)
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
}
