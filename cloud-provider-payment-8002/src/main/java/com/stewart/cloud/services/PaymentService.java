package com.stewart.cloud.services;

import com.stewart.web.entities.Payment;

/**
 * @author stewart
 * @since 2020-08-11
 */
public interface PaymentService {

    int save(Payment payment);

    Payment getById(Long id);

}
