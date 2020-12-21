package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author suchaobin
 * @description 订单service
 * @date 2020/12/18 23:47
 **/
public interface OrderService extends IService<Order> {

    /**
     * 创建订单
     *
     * @param order
     */
    void creatOrder(Order order);
}
