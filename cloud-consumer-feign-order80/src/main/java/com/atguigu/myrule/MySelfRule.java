package com.atguigu.myrule;

import com.atguigu.springcloud.lb.MyLoadBalancer;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author suchaobin
 * @description 自定义ribbon规则
 * @date 2020/9/3 10:11
 **/
@Configuration
public class MySelfRule {
    @Bean
    public IRule getMyRule() {
        return new MyLoadBalancer();
    }
}
