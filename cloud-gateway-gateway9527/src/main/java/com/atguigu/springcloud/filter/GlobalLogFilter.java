package com.atguigu.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author suchaobin
 * @description 全局日志过滤器
 * @date 2020/12/8 22:56
 **/
@Component
@Slf4j
public class GlobalLogFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("==========进入gateway网关的过滤器中==========");
        // 获取请求地址的第一个参数名为name的参数值
        String name = exchange.getRequest().getQueryParams().getFirst("name");
        if (null == name) {
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            log.error("==========参数name=null，已被gateway过滤！==============");
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
