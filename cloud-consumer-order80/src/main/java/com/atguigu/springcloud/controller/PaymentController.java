package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommenResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author suchaobin
 * @description controller入口
 * @date 2020/8/13 8:53
 **/
@RestController
@RequestMapping("/consumer")
public class PaymentController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancer loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/payment/";

    @GetMapping(value = "/add")
    @SuppressWarnings(value = "unchecked")
    public CommenResult<Payment> addPayment(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "add", payment, CommenResult.class);
    }

    @GetMapping(value = "/get/{id}")
    @SuppressWarnings(value = "unchecked")
    public CommenResult<Payment> getPaymentById(@PathVariable(value = "id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "get/" + id, CommenResult.class);
    }

    @GetMapping(value = "/getForEntity/{id}")
    @SuppressWarnings(value = "unchecked")
    public CommenResult<Payment> getPayment(@PathVariable(value = "id") Long id) {
        ResponseEntity<CommenResult> entity = restTemplate.getForEntity(PAYMENT_URL + "get/" + id,
                CommenResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }
        return new CommenResult<Payment>(500, "查询错误！");
    }

    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instance(instances);
        URI uri = serviceInstance.getUri();
        // 这边的restTemplate要在config配置类中取消@LoadBalanced，原因是之前是通过服务名选取所有的服务，然后做负载均衡处理。
        // 现在是先在所有的服务中计算，获取本次应该选用的服务，所以是根据具体的url进行操作，而只有一个服务，所以需要取消@LoadBalanced
        return restTemplate.getForObject(uri + "/payment/discovery", Object.class);
    }

    @GetMapping(value = "/zipkin")
    public Object zipkin() {
        return restTemplate.getForObject(PAYMENT_URL + "zipkin", String.class);
    }
}
