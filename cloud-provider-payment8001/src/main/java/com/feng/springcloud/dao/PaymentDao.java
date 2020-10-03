package com.feng.springcloud.dao;

import com.feng.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
