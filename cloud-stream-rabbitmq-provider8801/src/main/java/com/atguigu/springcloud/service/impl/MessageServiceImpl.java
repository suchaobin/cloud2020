package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilderFactory;
import org.springframework.messaging.MessageChannel;
import org.springframework.integration.support.MessageBuilder;
import javax.annotation.Resource;
import org.springframework.cloud.stream.messaging.Source;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author suchaobin
 * @description 消息发送接口
 * @date 2020/12/10 23:15
 **/
@EnableBinding(Source.class)
public class MessageServiceImpl implements IMessageService {
    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public String send()
    {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: "+serial);
        return null;
    }
}
