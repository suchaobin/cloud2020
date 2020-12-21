package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author suchaobin
 * @description 启动类
 * @date 2020/12/21 22:59
 **/
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class IDGenerateMain8888 {
    public static void main(String[] args) {
        SpringApplication.run(IDGenerateMain8888.class, args);
    }
}
