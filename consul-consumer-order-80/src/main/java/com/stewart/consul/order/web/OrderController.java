package com.stewart.consul.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

//    private final String CONSUL_PAYMENT_URL = "http://localhost:8006";

    private final String CONSUL_PAYMENT_URL = "http://consul-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/consul")
    private String payment() {
        return restTemplate.getForObject(CONSUL_PAYMENT_URL + "/payment/consul", String.class);
    }

}
