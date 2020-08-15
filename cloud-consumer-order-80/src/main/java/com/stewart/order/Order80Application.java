package com.stewart.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Order80Application {

    public static void main(String[] args) {
        SpringApplication.run(Order80Application.class, args);
    }

}
