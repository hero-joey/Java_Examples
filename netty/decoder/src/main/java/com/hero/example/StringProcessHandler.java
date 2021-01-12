package com.hero.example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @description: StringProcessHandler
 * @date: 2021/1/8
 * @author: bear
 * @version: 1.0
 */
public class StringProcessHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof String) {
            String message = (String) msg;
            System.out.println("String Handler: " + message);
        } else {
            super.channelRead(ctx, msg);
        }
    }
}
