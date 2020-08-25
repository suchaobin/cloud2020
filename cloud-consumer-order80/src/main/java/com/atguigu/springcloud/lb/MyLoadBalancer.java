package com.atguigu.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author suchaobin
 * @description 自定义负载均衡
 * @date 2020/8/25 10:31
 **/
@Component
@Slf4j
public class MyLoadBalancer implements LoadBalancer {
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 将当前的atomicInteger的值+1并返回
     *
     * @return 当前的atomicInteger的值+1
     */
    private int incrementAndGet() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (this.atomicInteger.compareAndSet(current, next));
        System.err.println("*******第几次访问，次数next: " + next);
        return next;
    }

    /**
     * 初始化ServiceInstance
     *
     * @param serviceInstances 所有的服务实例
     * @return 初始化的ServiceInstance
     */
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = incrementAndGet() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
