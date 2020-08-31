package com.steart.cloud.hystrix.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.steart.cloud.hystrix.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
// Hystrix全局fallback
@DefaultProperties(defaultFallback = "globalFallbackErrorHandler")
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfoOK(Long id) {
        return Thread.currentThread().getName() + "\t" + "paymentInfoOK(),id:" + id + "\t" + "成功调用";
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutErrorHandler", commandProperties = {
            // 接口调用超时时间，默认1S
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @Override
    public String paymentInfoTimeout(Long id) {
        if(id > 10){
            // 服务内部错误降级
            int age  = 10/0;
        }
        //
        try {
            // 接口超时降级
            TimeUnit.SECONDS.sleep(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + " id:  " + id + "\t" + "  耗时(秒): " + id;
    }

    //使用全局fallback
    @HystrixCommand
    @Override
    public String paymentError(Long id) {
        if(id > 10){
            // 服务内部错误降级
            int age  = 10/0;
        }
        //
        try {
            // 接口超时降级
            TimeUnit.SECONDS.sleep(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + " id:  " + id + "\t" + "  耗时(秒): " + id;
    }

    public String paymentInfoTimeoutErrorHandler(Long id) {
        return "线程池:  " + Thread.currentThread().getName() + " hystrix8001系统繁忙，请稍后重试" + " id:  " + id;
    }

    public String globalFallbackErrorHandler(){
        return "线程池:  " + Thread.currentThread().getName() + " hystrix8001系统繁忙-GLOBAL，请稍后重试";
    }

}
