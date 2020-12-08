package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author suchaobin
 * @description controller层
 * @date 2020/12/7 08:22
 **/
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id) {
        return paymentService.paymentInfo_OK(id);
    }

    @GetMapping("payment/hystrix/timeOut/{id}")
    public String paymentInfo_TimeOut(@PathVariable Integer id) {
        return paymentService.paymentInfo_TimeOut(id);
    }
}
