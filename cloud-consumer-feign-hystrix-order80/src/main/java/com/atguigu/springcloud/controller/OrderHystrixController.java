package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author suchaobin
 * @description controller层
 * @date 2020/12/7 19:18
 **/
@RestController
public class OrderHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("consumer/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("consumer/hystrix/timeOut/{id}")
    public String paymentInfo_TimeOut(@PathVariable Integer id) {
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }
}
