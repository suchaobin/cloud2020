package com.atguigu.springcloud.service;

import java.util.List;

/**
 * @author suchaobin
 * @description id生成器
 * @date 2020/12/21 23:03
 **/
public interface IDGenerateService {
    /**
     * 生成id
     *
     * @param num 生成数量
     * @return
     */
    List<Long> generateIds(int num);
}
