package com.stewart.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServer3301Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer3301Application.class, args);
    }

}
