package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommenResult;
import com.atguigu.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author suchaobin
 * @description controller入口
 * @date 2020/8/13 8:53
 **/
@RestController
@RequestMapping("/consumer")
public class PaymentController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String PAYMENT_URL = "http://localhost:8001/payment/";

    @GetMapping(value = "/add")
    @SuppressWarnings(value = "unchecked")
    public CommenResult<Payment> addPayment(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "add", payment, CommenResult.class);
    }

    @GetMapping(value = "/get/{id}")
    @SuppressWarnings(value = "unchecked")
    public CommenResult<Payment> getPaymentById(@PathVariable(value = "id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "get/" + id, CommenResult.class);
    }
}
