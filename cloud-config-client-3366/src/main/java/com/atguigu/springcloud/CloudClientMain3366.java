package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author suchaobin
 * @description 启动类
 * @date 2020/12/10 21:49
 **/
@SpringBootApplication
@EnableEurekaClient
public class CloudClientMain3366 {
    public static void main(String[] args) {
        SpringApplication.run(CloudClientMain3366.class, args);
    }
}
