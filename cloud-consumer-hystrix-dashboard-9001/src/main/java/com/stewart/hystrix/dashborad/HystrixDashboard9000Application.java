package com.stewart.hystrix.dashborad;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboard9000Application {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9000Application.class, args);
    }

}
