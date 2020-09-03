package com.stewart.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Gateway9527Application {

    public static void main(String[] args) {
        SpringApplication.run(Gateway9527Application.class, args);
    }

}