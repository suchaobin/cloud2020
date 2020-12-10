package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author suchaobin
 * @description 消息接收controller
 * @date 2020/12/10 23:46
 **/
@EnableBinding(Sink.class)
@Component
public class MessageReceiveController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.err.println("端口=" + serverPort + ", message=" + message.getPayload());
    }
}
