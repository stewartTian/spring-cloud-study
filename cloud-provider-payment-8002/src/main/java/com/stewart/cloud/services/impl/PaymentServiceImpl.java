package com.stewart.cloud.services.impl;

import com.stewart.cloud.mapper.PaymentMapper;
import com.stewart.cloud.services.PaymentService;
import com.stewart.web.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author stewart
 * @since 2020-08-11
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int save(Payment payment) {
        return paymentMapper.save(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentMapper.getById(id);
    }

}
