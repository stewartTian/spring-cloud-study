package com.steart.cloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
//开启服务降级
@EnableCircuitBreaker
@SpringBootApplication
public class HystrixPayment8001Application {

    public static void main(String[] args) {
        SpringApplication.run(HystrixPayment8001Application.class, args);
    }
}
