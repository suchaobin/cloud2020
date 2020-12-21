package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.StorageDao;
import com.atguigu.springcloud.entity.Storage;
import com.atguigu.springcloud.service.StorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author suchaobin
 * @description service
 * @date 2020/12/21 08:13
 **/
@Service
public class StorageServiceImpl extends ServiceImpl<StorageDao, Storage> implements StorageService {
    @Autowired
    private StorageDao storageDao;

    /**
     * 扣库存
     *
     * @param productId 产品id
     * @param count     扣除数量
     */
    @Override
    public void decreaseStorage(Long productId, Integer count) {
        storageDao.decreaseStorage(productId, count);
    }
}
