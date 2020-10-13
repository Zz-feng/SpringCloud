package com.feng.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public String PaymentInfo_OK(Integer id){
        return "线程池： " + Thread.currentThread().getName() + "PaymentInfo_OK, id = " + id;
    }

    @HystrixCommand(fallbackMethod = "PaymentInfo_TimeOutHandle", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String PaymentInfo_TimeOut(Integer id){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + "PaymentInfo_TimeOut, id = " + id;
    }

    public String PaymentInfo_TimeOutHandle(Integer id){
        return "线程池： " + Thread.currentThread().getName() + "PaymentInfo_TimeOut, id = " + id + "    o(╥﹏╥)o";
    }

}
