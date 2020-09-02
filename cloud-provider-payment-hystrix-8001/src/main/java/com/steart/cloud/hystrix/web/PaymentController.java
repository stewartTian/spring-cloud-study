package com.steart.cloud.hystrix.web;

import com.steart.cloud.hystrix.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/hystrix/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Long id) {
        String result = paymentService.paymentInfoOK(id);
        log.info("result:{}", result);
        return result;
    }

    @GetMapping("/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Long id) {
        String result = paymentService.paymentInfoTimeout(id);
        log.info("result:{}", result);
        return result;
    }

    @GetMapping("/error/{id}")
    public String paymentError(@PathVariable("id") Long id) {
        String result = paymentService.paymentError(id);
        log.info("result:{}", result);
        return result;
    }

    @GetMapping("/breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String breaker = paymentService.paymentCircuitBreaker(id);
        log.info("result:{}", breaker);
        return breaker;
    }

}
