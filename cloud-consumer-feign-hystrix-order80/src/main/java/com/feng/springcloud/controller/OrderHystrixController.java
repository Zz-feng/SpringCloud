package com.feng.springcloud.controller;

import com.feng.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    @ResponseBody
    public String PaymentInfo_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.PaymentInfo_OK(id);
    }

//    @HystrixCommand(fallbackMethod = "PaymentInfo_TimeOutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    //@HystrixCommand
    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    @ResponseBody
    public String PaymentInfo_TimeOut(@PathVariable("id") Integer id){
        return paymentHystrixService.PaymentInfo_TimeOut(id);
    }

    public String PaymentInfo_TimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80，对方支付系统繁忙";
    }
}
