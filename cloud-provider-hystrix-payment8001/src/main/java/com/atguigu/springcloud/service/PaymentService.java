package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * @author suchaobin
 * @description 支付service
 * @date 2020/12/7 08:17
 **/
@Service
public class PaymentService {

    // ========服务降级==========

    /**
     * 成功
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "okFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + ", paymentInfo_OK, id:" + id;
    }

    public String okFallBack(Integer id) {
        return "-----PaymentService okFallBack 8001 ------";
    }

    /**
     * 超时
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "timeOutFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeOut = 5000;
        try {
            Thread.sleep(timeOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //int a = 10 / 0;
        return "线程池:" + Thread.currentThread().getName() + ", paymentInfo_TimeOut, id:" + id;
    }

    public String timeOutFallBack(Integer id) {
        return "-----PaymentService timeOutFallBack 8001 ------";
    }

    // ========服务熔断==========
    @HystrixCommand(fallbackMethod = "breakFallBack", commandProperties = {
            // 该配置表示允许开启熔断器，在10秒内，如果有至少10个请求进入，且60%的请求发生错误，那么将开启熔断器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 熔断器切换状态要求的最低请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 熔断器切换状态的判断时间
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")// 失败率，超过这个数熔断器就会打开
    })
    public String paymentInfo_break(Integer id) {
        if (id < 0) {
            throw new RuntimeException();
        }
        return "线程池:" + Thread.currentThread().getName() + ", paymentInfo_TimeOut, id:" + id;
    }

    public String breakFallBack(Integer id) {
        return "-----id不能为负数 ------";
    }
}
