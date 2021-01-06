package com.hero.discardserver.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @description: SimpleInHandlerC
 * @date: 2021/1/5
 * @author: bear
 * @version: 1.0
 */
public class SimpleInHandlerC extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("入站处理C回调");
        super.channelRead(ctx, msg);
    }
}
