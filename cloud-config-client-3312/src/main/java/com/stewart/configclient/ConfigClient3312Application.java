package com.stewart.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ConfigClient3312Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3312Application.class,args);
    }

}
