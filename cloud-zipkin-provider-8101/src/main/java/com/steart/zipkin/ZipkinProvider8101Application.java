package com.steart.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ZipkinProvider8101Application {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinProvider8101Application.class, args);
    }

}
