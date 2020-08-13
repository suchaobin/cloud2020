package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommenResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author suchaobin
 * @description controller层
 * @date 2020/8/12 17:42
 **/
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/get/{id}")
    @ResponseBody
    public CommenResult<Payment> getPaymentById(@PathVariable(value = "id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (null == payment) {
            return new CommenResult<>(500, "没有对应记录,id=" + id, null);
        }
        return new CommenResult<>(200, "查询成功", payment);
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public CommenResult<Payment> addPayment(@RequestBody Payment payment) {
        int result = paymentService.addPayment(payment);
        if (result < 0) {
            return new CommenResult<>(500, "插入失败", null);
        }
        return new CommenResult<>(200, "插入成功", payment);
    }
}
