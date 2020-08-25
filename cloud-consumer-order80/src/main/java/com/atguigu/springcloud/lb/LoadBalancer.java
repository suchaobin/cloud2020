package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author suchaobin
 * @description 负载均衡接口
 * @date 2020/8/25 10:29
 **/
public interface LoadBalancer {
    /**
     * 初始化ServiceInstance
     *
     * @param serviceInstances 所有的服务实例
     * @return
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
