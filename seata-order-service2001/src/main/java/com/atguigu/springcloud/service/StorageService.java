package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author suchaobin
 * @description 库存service
 * @date 2020/12/19 00:00
 **/
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping("/storage/decrease")
    CommonResult decreaseStorage(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
