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
public class Integer2BytebufEncoder extends MessageToByteEncoder<Integer> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Integer msg, ByteBuf out) throws Exception {
        out.writeInt(msg);
        System.out.println("Encoder integer: " + msg);
    }
}
