package com.hero.rabbitmq.service;

import com.hero.rabbitmq.pojo.BizDetail;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * @description: MessageSender
 * @date: 2020/9/9 16:18
 * @author: maccura
 * @version: 1.0
 */
@Component
public class MessageSender {
    @Value("${biz.message.routingkey}")
    private String routingKey;
    @Value("${biz.message.exchange}")
    private String exchange;
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostConstruct
    public void initMessageSender() {
        //启动消息失败返回，比如路由不到队列时触发回调,只有失败场景返回，正常返回
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println(message);
                System.out.println(replyCode);
                System.out.println(replyText);
            }
        });

        //消息发送到 Broker后触发回调，确认消息是否到达Broker服务器，也就是只确认是否正确到达 Exchange 中
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println(correlationData.getId());
                System.out.println(ack);
                System.out.println(cause);
            }
        });
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
    }

    public void sendMessage() {
        BizDetail bizDetail = new BizDetail();
        bizDetail.setBizId(UUID.randomUUID().toString().replace("-", ""));
        bizDetail.setBizName("Test: " + bizDetail.getBizId());
        bizDetail.setBizOperator("hero");
        CorrelationData correlationData = new CorrelationData(bizDetail.getBizId());

        rabbitTemplate.convertAndSend(exchange, routingKey, bizDetail, correlationData);
        System.out.println("Send Message: " + bizDetail);




    }
}
