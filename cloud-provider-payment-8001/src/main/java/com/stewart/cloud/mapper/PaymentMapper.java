package com.stewart.cloud.mapper;

import com.stewart.web.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author stewart
 * @since 2020-08-11
 */
@Mapper
public interface PaymentMapper {

    int save(Payment payment);

    Payment getById(Long id);

}
