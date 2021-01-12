package com.hero.example;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @description: Integet2BytebufEncoder
 * @date: 2021/1/12
 * @author: bear
 * @version: 1.0
 */
public class Double2BytebufEncoder extends MessageToByteEncoder<Double> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Double msg, ByteBuf out) throws Exception {
        out.writeDouble(msg);
        System.out.println("Encoder Double : " + msg);
    }
}
