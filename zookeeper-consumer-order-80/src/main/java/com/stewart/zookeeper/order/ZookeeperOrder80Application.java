package com.stewart.zookeeper.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ZookeeperOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperOrder80Application.class, args);
    }

}
