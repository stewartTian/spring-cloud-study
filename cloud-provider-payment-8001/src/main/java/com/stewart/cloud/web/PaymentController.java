package com.stewart.cloud.web;

import com.stewart.cloud.services.PaymentService;
import com.stewart.web.CommonResult;
import com.stewart.web.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author stewart
 * @since 2020-08-11
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/save")
    public CommonResult<Object> savePayment(@RequestBody Payment payment) {
        int save = paymentService.save(payment);
        if (save > 0) {
            return new CommonResult<>(200, "插入成功,端口：" + serverPort);
        } else {
            return new CommonResult<>(400, "插入失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);
        if (payment != null) {
            log.info("查询数据入参：id = {}", id);
            return new CommonResult<>(200, "查询成功,端口：" + serverPort, payment);
        } else {
            return new CommonResult<>(400, "查询失败");
        }
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service : {}", service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info("instance : {}, host : {}, port : {} , url : {}", instance.getInstanceId(), instance.getHost(), instance.getPort(), instance.getUri());
            }
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;
    }

}
