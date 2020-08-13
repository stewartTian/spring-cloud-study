package com.stewart.cloud.web;

import com.stewart.cloud.services.PaymentService;
import com.stewart.web.CommonResult;
import com.stewart.web.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author stewart
 * @since 2020-08-11
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/save")
    public CommonResult<Object> savePayment(@RequestBody Payment payment) {
        int save = paymentService.save(payment);
        if (save > 0) {
            return new CommonResult<>(200, "插入成功");
        } else {
            return new CommonResult<>(400, "插入失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);
        if (payment != null) {
            log.info("查询数据入参：id = {}", id);
            return new CommonResult<>(200, "查询成功", payment);
        } else {
            return new CommonResult<>(400, "查询失败");
        }
    }

}
