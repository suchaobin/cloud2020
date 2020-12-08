package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @author suchaobin
 * @description 统一的降级service
 * @date 2020/12/7 21:54
 **/
@Service
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "统一的降级service-ok-80";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "统一的降级service-timeout-80";
    }
}
