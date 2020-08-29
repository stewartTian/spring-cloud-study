package com.stewart.hystrix.order.other.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/hystrix/payment")
@FeignClient("CLOUD-PROVIDER-PAYMENT-HYSTRIX")
public interface PaymentAPI {

    @GetMapping("/ok/{id}")
    String paymentInfoOK(@PathVariable("id") Long id);

    @GetMapping("/timeout/{id}")
    String paymentInfoTimeout(@PathVariable("id") Long id);

}
