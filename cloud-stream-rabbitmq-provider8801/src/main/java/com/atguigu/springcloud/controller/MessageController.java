package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author suchaobin
 * @description 发送消息controller
 * @date 2020/12/10 23:17
 **/
@RestController
public class MessageController {
    @Autowired
    private IMessageService messageService;

    @GetMapping("message/send")
    public String send() {
        return messageService.send();
    }
}
