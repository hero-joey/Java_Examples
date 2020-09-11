package com.hero.rabbitmq.controller;

import com.hero.rabbitmq.service.MessageSender;
import com.hero.rabbitmq.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: RabbitmqController
 * @date: 2020/9/10 10:17
 * @author: maccura
 * @version: 1.0
 */
@RestController
public class RabbitmqController {

    private MessageService messageService;

    @Autowired
    public RabbitmqController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/publish")
    public void publishMessage() {
        messageService.sendMessage();
    }
}
