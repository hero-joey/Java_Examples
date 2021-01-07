package com.hero.echoserver.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;

/**
 * @description: EchoServerHandler
 * @date: 2021/1/4
 * @author: bear
 * @version: 1.0
 */
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, final Object msg) throws Exception {
        final ByteBuf byteBuf = (ByteBuf) msg;
        if (byteBuf.hasArray()) {
            System.out.println("Heap memory");
        } else {
            byte[] bytes = new byte[byteBuf.readableBytes()];
            byteBuf.getBytes(0, bytes);
            System.out.println("Server received: " + byteBuf.toString(CharsetUtil.UTF_8));
            System.out.println("Message refCnt: " + byteBuf.refCnt());
            ChannelFuture channelFuture = ctx.writeAndFlush(msg);
            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    System.out.println("写回后,Message refCnt: " + byteBuf.refCnt());
                }
            });

        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
