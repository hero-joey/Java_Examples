package com.hero.example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @description: IntegerProcessHandler
 * @date: 2021/1/7
 * @author: bear
 * @version: 1.0
 */
public class IntegerProcessHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Integer integer = (Integer) msg;
        System.out.println("打印出一个整数: " + integer);
    }
}
