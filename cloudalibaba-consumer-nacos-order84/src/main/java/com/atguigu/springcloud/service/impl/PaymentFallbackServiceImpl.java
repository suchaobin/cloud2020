package com.atguigu.springcloud.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.controller.CircleBreakerController;
import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentFallbackService;
import org.springframework.stereotype.Service;

/**
 * @author suchaobin
 * @description 实现类
 * @date 2020/12/17 08:37
 **/
@Service
public class PaymentFallbackServiceImpl implements PaymentFallbackService {
    @Override
    @SentinelResource(value = "paymentFallback", blockHandlerClass = CircleBreakerController.class, blockHandler = "blockHandler")
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, " 服务降级返回 ,---PaymentFallbackService", new Payment(id, "errorSerial"));
    }

}
