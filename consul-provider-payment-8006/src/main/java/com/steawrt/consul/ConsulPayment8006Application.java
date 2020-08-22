package com.steawrt.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsulPayment8006Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsulPayment8006Application.class, args);
    }

}
