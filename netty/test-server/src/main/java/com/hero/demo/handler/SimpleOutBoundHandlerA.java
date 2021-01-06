package com.hero.demo.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @description: SimpleOutBoundHandlerA
 * @date: 2021/1/6 16:55
 * @author: maccura
 * @version: 1.0
 */
public class SimpleOutBoundHandlerA extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("出站处理器A被回调");
        super.write(ctx, msg, promise);
    }
}
