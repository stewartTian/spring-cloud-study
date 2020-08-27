package com.stewart.feign.order.web;

import com.stewart.feign.order.other.api.PaymentAPI;
import com.stewart.web.CommonResult;
import com.stewart.web.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign/order")
public class OrderController {

    @Autowired
    private PaymentAPI paymentAPI;

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentAPI.getPaymentById(id);
    }

    @GetMapping("/timeout")
    public String paymentFeignTimeout() {
        return paymentAPI.paymentFeignTimeout();
    }

}
