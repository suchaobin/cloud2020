package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author suchaobin
 * @description controller
 * @date 2020/12/15 08:00
 **/
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    @SentinelResource(value = "/retaLimit/byUrl")
    public String testA() {
        return "----testA----";
    }

    @GetMapping("/testB")
    public String testB() {
        try {
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "----testB----";
    }

    @GetMapping("/testC")
    public String testC() {
        return test();
    }

    @SentinelResource("test")
    public String test() {
        return "----testC----";
    }
}
