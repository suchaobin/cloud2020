package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.AccountDao;
import com.atguigu.springcloud.entity.Account;
import com.atguigu.springcloud.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author suchaobin
 * @description service
 * @date 2020/12/21 08:45
 **/
@Service
public class AccountServiceImpl extends ServiceImpl<AccountDao, Account> implements AccountService {
    @Autowired
    private AccountDao accountDao;

    /**
     * 扣钱
     *
     * @param userId 用户id
     * @param money  钱
     */
    @Override
    public void decreaseAccount(Long userId, BigDecimal money) {
        accountDao.decreaseAccount(userId, money);
    }
}
