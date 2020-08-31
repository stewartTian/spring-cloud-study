package com.stewart.hystrix.order.other.api.impl;

import com.stewart.hystrix.order.other.api.PaymentAPI;
import org.springframework.stereotype.Component;

//feign服务降级业务代码和降级代码分离
@Component
public class PaymentAPIFallback implements PaymentAPI {

    @Override
    public String paymentInfoOK(Long id) {
        return "paymentInfoOK error";
    }

    @Override
    public String paymentInfoTimeout(Long id) {
        return "paymentInfoTimeout error";
    }

}
