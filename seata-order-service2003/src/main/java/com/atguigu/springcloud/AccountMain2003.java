package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author suchaobin
 * @description 启动类
 * @date 2020/12/21 08:42
 **/
@MapperScan(basePackages = "com.atguigu.springcloud.dao")
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AccountMain2003 {
    public static void main(String[] args) {
        SpringApplication.run(AccountMain2003.class, args);
    }
}
