package com.cloud.easyverify.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @PackageName: com.cloud.easyverify.config
 * @ClassName: RandomRule
 * @Description: This is RandomRule class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 15:58
 */
@Configuration
public class RandomRule {
    @Bean
    public IRule myRule(){
        //        return new RandomRule();//随机策略
        return new RoundRobinRule();
        //轮询策略
    }
}
