package com.atguigu.springcloud.lb;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author suchaobin
 * @description 自定义负载均衡
 * @date 2020/9/3 14:11
 **/
public class MyLoadBalancer implements LoadBalancer {

    private final AtomicInteger atomicInteger = new AtomicInteger(0);
    private ILoadBalancer lb;

    @Override
    public Server choose(Object key) {
        List<Server> servers = this.lb.getReachableServers();
        int index = incrementAndGet() % servers.size();
        return servers.get(index);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        this.lb = lb;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.lb;
    }

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
        } while (!this.atomicInteger.compareAndSet(current, next));
        return next;
    }
}
