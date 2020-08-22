package com.stewart.consul.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsulOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsulOrder80Application.class, args);
    }

}
