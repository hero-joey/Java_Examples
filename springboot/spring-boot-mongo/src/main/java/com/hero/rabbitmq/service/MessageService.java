package com.hero.rabbitmq.service;

import com.hero.rabbitmq.pojo.BizDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: MessageService
 * @date: 2020/9/9 16:18
 * @author: maccura
 * @version: 1.0
 */
@Service
public class MessageService {
    private MessageSender messageSender;

    @Autowired
    public MessageService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendMessage() {
        messageSender.sendMessage();
    }
}
