package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author suchaobin
 * @description 启动类
 * @date 2020/12/13 11:15
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class NacosClientConfigMain3377 {

    public static void main(String[] args) {
        SpringApplication.run(NacosClientConfigMain3377.class, args);
    }
}
