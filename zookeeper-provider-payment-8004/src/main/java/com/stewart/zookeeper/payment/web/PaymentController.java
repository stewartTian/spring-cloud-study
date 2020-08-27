package com.stewart.zookeeper.payment.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/zookeeper/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/port")
    public String paymentZookeeper() {
        return "springCloud with zookeeper: " + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
