package com.stewart.ribbon.order.web;

import com.stewart.ribbon.order.loadbalancer.LoadBalancer;
import com.stewart.web.CommonResult;
import com.stewart.web.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ribbon/order")
public class OrderController {

    private final String PAYMENT_URL = "http://cloud-provider-payment";

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancer loadBalancer;

    @PostMapping("/payment/save")
    public CommonResult<Payment> savePayment(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/payment/lb")
    public String getPaymentLb() {
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-payment");
        if (CollectionUtils.isEmpty(instances)) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

}
