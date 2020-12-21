package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IDGenerateService;
import com.atguigu.springcloud.util.IDGenerateSnowFlack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author suchaobin
 * @description id生成器
 * @date 2020/12/21 23:03
 **/
@Service
public class IDGenerateServiceImpl implements IDGenerateService {
    @Autowired
    private IDGenerateSnowFlack idGenerateSnowFlack;

    /**
     * 生成id
     *
     * @param num 生成数量
     * @return
     */
    @Override
    public List<Long> generateIds(int num) {
        // 创建5个线程，多线程生成id
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Long> ids = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            executorService.submit(() -> {
                long snowFlakId = idGenerateSnowFlack.getSnowFlakId();
                ids.add(snowFlakId);
            });
        }
        executorService.shutdown();
        return ids;
    }
}
