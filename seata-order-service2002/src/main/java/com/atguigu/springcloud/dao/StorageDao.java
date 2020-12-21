package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entity.Storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author suchaobin
 * @description dao层
 * @date 2020/12/21 08:11
 **/
public interface StorageDao extends BaseMapper<Storage> {
    /**
     * 扣除库存
     *
     * @param productId 产品id
     * @param count     扣除数量
     */
    void decreaseStorage(@Param("productId")Long productId, @Param("count") Integer count);
}
