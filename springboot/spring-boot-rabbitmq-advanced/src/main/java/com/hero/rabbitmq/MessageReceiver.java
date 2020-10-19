package com.hero.rabbitmq;

import com.hero.rabbitmq.pojo.BizDetail;
import com.rabbitmq.client.Channel;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @description: MessageReceiver
 * @date: 2020/9/9 16:37
 * @author: maccura
 * @version: 1.0
 */
@Component
public class MessageReceiver {
    @RabbitHandler
    @RabbitListener(queues = "${biz.message.queue}", containerFactory = "rabbitListenerContainerFactory")
    public void onBizMessage(@Payload BizDetail bizDetail, @Headers Map<String,Object> headers, Channel channel ) {

        try {
            System.out.println(Thread.currentThread().getName() + bizDetail.toString());
            Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
            channel.basicAck(deliveryTag, true);

        } catch (IOException e) {
            //TODO::网络断开，无法回复场景，如何解决
            e.printStackTrace();
        }
    }

//    @RabbitHandler
//    @RabbitListener(queues = "messageQueue")
//    public void onBizMessage(Message message, @Headers Map<String,Object> headers, Channel channel ) {
//        System.out.println(new String((byte[]) message.getPayload()));
//    }

}
