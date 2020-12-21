package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
 * @author suchaobin
 * @description service
 * @date 2020/12/21 08:45
 **/
public interface AccountService extends IService<Account> {
    /**
     * 扣钱
     *
     * @param userId 用户id
     * @param money  钱
     */
    void decreaseAccount(Long userId, BigDecimal money);
}
