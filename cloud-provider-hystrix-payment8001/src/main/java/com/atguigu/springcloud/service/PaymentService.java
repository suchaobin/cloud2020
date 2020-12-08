package com.atguigu.springcloud.service;

import com.netflix.hystrix.HystrixCommandProperties;
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
}
