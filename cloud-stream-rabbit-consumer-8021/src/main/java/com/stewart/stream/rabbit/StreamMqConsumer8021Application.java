package com.stewart.stream.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StreamMqConsumer8021Application {

    public static void main(String[] args) {
        SpringApplication.run(StreamMqConsumer8021Application.class, args);
    }

}
