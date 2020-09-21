package com.stewart.zipkin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ZipkinConsumer8102Application {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinConsumer8102Application.class, args);
    }

}
