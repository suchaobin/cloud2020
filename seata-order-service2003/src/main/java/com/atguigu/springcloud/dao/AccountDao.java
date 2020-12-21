package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author suchaobin
 * @description dao
 * @date 2020/12/21 08:43
 **/
public interface AccountDao extends BaseMapper<Account> {

    /**
     * 扣钱
     *
     * @param userId 用户id
     * @param money  钱
     */
    void decreaseAccount(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
