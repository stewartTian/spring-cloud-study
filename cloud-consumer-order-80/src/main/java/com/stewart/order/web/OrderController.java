package com.stewart.order.web;

import com.stewart.web.CommonResult;
import com.stewart.web.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

//    private final String PAYMENT_URL = "http://localhost:8001";

    private final String PAYMENT_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/payment/save")
    public CommonResult<Payment> savePayment(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/payment/getEntity/{id}")
    public CommonResult<Payment> getPaymentEntityById(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        HttpStatus statusCode = entity.getStatusCode();
        if (statusCode.is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult<>(400, "查询失败");
        }
    }

}
