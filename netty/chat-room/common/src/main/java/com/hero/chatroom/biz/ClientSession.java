package com.hero.chatroom.biz;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.AttributeKey;

/**
 * @description: ClientSession
 * @date: 2021/1/18
 * @author: bear
 * @version: 1.0
 */
public class ClientSession {

    public static final AttributeKey<ClientSession> sessionAttributeKey = AttributeKey.valueOf("Session");
    private Channel channel;
    private Boolean connected;
    public ClientSession(Channel channel, Boolean connected) {
        this.channel = channel;
        this.connected = connected;
    }

    public void close() {
        connected = false;

        ChannelFuture future = channel.close();
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("连接断开完成");
                }
            }
        });
    }
}
