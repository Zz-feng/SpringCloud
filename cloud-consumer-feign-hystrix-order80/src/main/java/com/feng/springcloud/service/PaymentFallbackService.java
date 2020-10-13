package com.feng.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String PaymentInfo_OK(Integer id) {
        return "PaymentFallbackService PaymentInfo_OK";
    }

    @Override
    public String PaymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService PaymentInfo_TimeOut";
    }
}
