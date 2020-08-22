package com.stewart.ribbon.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RibbonOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(RibbonOrder80Application.class, args);
    }

}
