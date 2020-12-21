package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author suchaobin
 * @description controller
 * @date 2020/12/21 08:16
 **/
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    //扣减库存
    @RequestMapping("/account/decrease")
    public CommonResult decrease(Long userId, BigDecimal money) {
        accountService.decreaseAccount(userId, money);
        return new CommonResult(200, "扣减库存成功！");
    }
}
