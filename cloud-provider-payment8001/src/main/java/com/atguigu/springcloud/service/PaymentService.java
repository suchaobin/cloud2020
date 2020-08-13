package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Payment;

/**
 * @author suchaobin
 * @description service层
 * @date 2020/8/12 17:39
 **/
public interface PaymentService {
    /**
     * 添加Payment
     *
     * @param payment payment对象
     * @return
     */
    int addPayment(Payment payment);

    /**
     * 通过id获取Payment
     *
     * @param id id
     * @return
     */
    Payment getPaymentById(Long id);
}
