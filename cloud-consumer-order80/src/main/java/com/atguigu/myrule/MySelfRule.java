package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author suchaobin
 * @description 自定义ribbon规则
 * @date 2020/8/25 10:17
 **/
@Configuration
public class MySelfRule {
    @Bean
    public IRule getMyRule() {
        return new RandomRule();
    }
}
