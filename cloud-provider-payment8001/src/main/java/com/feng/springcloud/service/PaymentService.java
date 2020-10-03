package com.feng.springcloud.service;

import com.feng.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
