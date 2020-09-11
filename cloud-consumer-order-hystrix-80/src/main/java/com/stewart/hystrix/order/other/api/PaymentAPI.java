package com.stewart.hystrix.order.other.api;

import com.stewart.hystrix.order.other.api.impl.PaymentAPIFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 使用feign做服务降级时，不要在类上使用@RequestMapping注解
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT-HYSTRIX", fallback = PaymentAPIFallback.class)
public interface PaymentAPI {

    @GetMapping("/hystrix/payment/ok/{id}")
    String paymentInfoOK(@PathVariable("id") Long id);

    @GetMapping("/hystrix/payment/timeout/{id}")
    String paymentInfoTimeout(@PathVariable("id") Long id);

}
