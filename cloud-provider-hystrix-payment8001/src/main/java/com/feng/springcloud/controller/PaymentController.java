package com.feng.springcloud.controller;

import com.feng.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    @ResponseBody
    public String PaymentInfo_OK(@PathVariable("id") Integer id){
        return paymentService.PaymentInfo_OK(id);
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    @ResponseBody
    public String PaymentInfo_TimeOut(@PathVariable("id") Integer id){
        return paymentService.PaymentInfo_TimeOut(id);
    }

}
