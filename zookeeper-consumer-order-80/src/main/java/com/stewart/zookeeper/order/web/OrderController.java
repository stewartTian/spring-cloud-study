package com.stewart.zookeeper.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    //    private final String ZOOKEEPER_PAYMENT_URL = "http://localhost:8004";

    private final String ZOOKEEPER_PAYMENT_URL = "http://cloud-provider-zookpeer-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/zookeeper")
    public String payment() {
        return restTemplate.getForObject(ZOOKEEPER_PAYMENT_URL + "/payment/zookeeper", String.class);
    }

}
