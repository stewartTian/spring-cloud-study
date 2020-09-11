package com.stewart.hystrix.order.web;

import com.stewart.hystrix.order.other.api.PaymentAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hystrix/order")
public class OrderController {

    @Autowired
    private PaymentAPI paymentAPI;

    @GetMapping("/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Long id) {
        return paymentAPI.paymentInfoOK(id);
    }

    @GetMapping("/timeout/{id}")
    String paymentInfoTimeout(@PathVariable("id") Long id) {
        return paymentAPI.paymentInfoTimeout(id);
    }

}
