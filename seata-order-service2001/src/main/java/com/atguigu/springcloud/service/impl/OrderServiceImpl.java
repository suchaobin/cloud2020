package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.entity.Order;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author suchaobin
 * @description 订单service
 * @date 2020/12/18 23:52
 **/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private StorageService storageService;
    @Autowired
    private AccountService accountService;


    /**
     * 创建订单
     *
     * @param order
     */
    @Override
    public void creatOrder(Order order) {
        // 1.创建订单
        orderDao.insert(order);
        // 2.减库存
        storageService.decreaseStorage(order.getProductId(), order.getCount());
        // 3.扣钱
        accountService.decreaseAccount(order.getUserId(), order.getMoney());
        // 4.更改订单状态
        order.setStatus(1);
        orderDao.updateById(order);
    }
}
