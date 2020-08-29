package com.stewart.hystrix.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableHystrix
@EnableFeignClients
@SpringBootApplication
public class HystrixOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(HystrixOrder80Application.class, args);
    }

}
