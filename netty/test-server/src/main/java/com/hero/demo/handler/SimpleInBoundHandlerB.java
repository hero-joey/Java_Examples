package com.hero.demo.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @description: SimpleInBoundHandler
 * @date: 2021/1/6 16:46
 * @author: maccura
 * @version: 1.0
 */
public class SimpleInBoundHandlerB extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("入站处理器B被回调");
        ctx.fireChannelRead(msg);
        //super.channelRead(ctx, msg);
    }

}
