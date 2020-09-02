package com.steart.cloud.hystrix.service;

public interface PaymentService {

    String paymentInfoOK(Long id);

    String paymentInfoTimeout(Long id);

    String paymentError(Long id);

    //*** 服务熔断
    String paymentCircuitBreaker( Integer id);

}
