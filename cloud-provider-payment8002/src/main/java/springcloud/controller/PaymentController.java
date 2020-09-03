package springcloud.controller;

import com.atguigu.springcloud.entity.CommenResult;
import com.atguigu.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import springcloud.service.PaymentService;

import java.util.List;

/**
 * @author suchaobin
 * @description controller层
 * @date 2020/8/12 17:42
 **/
@RestController
@RequestMapping(value = "/payment")
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private int serverPort;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/get/{id}")
    @ResponseBody
    public CommenResult<Payment> getPaymentById(@PathVariable(value = "id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (null == payment) {
            return new CommenResult<>(500, "没有对应记录,id=" + id, null);
        }
        return new CommenResult<>(200, "查询成功,serverPort=" + serverPort, payment);
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public CommenResult<Payment> addPayment(@RequestBody Payment payment) {
        int result = paymentService.addPayment(payment);
        if (result < 0) {
            return new CommenResult<>(500, "插入失败", null);
        }
        return new CommenResult<>(200, "插入成功,serverPort=" + serverPort, payment);
    }

    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("server:{}", service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/feign/timeout")
    public int paymentFeignTimeout() {
        return serverPort;
    }
}
