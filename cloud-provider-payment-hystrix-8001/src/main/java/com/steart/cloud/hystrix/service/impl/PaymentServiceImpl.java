package com.steart.cloud.hystrix.service.impl;

import com.steart.cloud.hystrix.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfoOK(Long id) {
        return Thread.currentThread().getName() + "\t" + "paymentInfoOK(),id:" + id + "\t" + "成功调用";
    }

    @Override
    public String paymentInfoTimeout(Long id) {
        Integer timeOutNumber = 5;
        // int age  = 10/0;
        try {
            TimeUnit.SECONDS.sleep(timeOutNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + " id:  " + id + "\t" + "  耗时(秒): " + timeOutNumber;
    }
}
