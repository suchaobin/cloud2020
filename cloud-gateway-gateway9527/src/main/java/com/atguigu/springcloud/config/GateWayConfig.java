package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author suchaobin
 * @description gateway配置
 * @date 2020/12/8 22:32
 **/
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("myRoute", tmp -> tmp.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
