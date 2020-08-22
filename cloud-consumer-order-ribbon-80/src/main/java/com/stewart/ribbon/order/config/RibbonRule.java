package com.stewart.ribbon.order.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ribbon负载均衡规则切换
 */
@Configuration
public class RibbonRule {

    @Bean
    public IRule rule() {
        return new RandomRule();
    }

}
