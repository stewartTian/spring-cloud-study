package com.steart.cloud.hystrix.service;

public interface PaymentService {

    String paymentInfoOK(Long id);

    String paymentInfoTimeout(Long id);

}
