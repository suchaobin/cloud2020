package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Storage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author suchaobin
 * @description service
 * @date 2020/12/21 08:13
 **/
public interface StorageService extends IService<Storage> {

    /**
     * 扣库存
     *
     * @param productId 产品id
     * @param count     扣除数量
     */
    void decreaseStorage(Long productId, Integer count);
}
