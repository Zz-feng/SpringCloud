package com.feng.springcloud.controller;

import com.feng.springcloud.entities.CommonResult;
import com.feng.springcloud.entities.Payment;
import com.feng.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@Slf4j
@ResponseBody
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);

        if(result > 0){
            return new CommonResult(200, "插入数据库成功", result);
        }

        return new CommonResult(444, "插入数据库失败", null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);

        if(payment != null){
            return new CommonResult(200, "查询成功", payment);
        }

        return new CommonResult(444, "查询失败", null);
    }
}
