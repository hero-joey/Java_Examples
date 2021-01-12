package com.hero.example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @description: String2IntegerEncoder
 * @date: 2021/1/12
 * @author: bear
 * @version: 1.0
 */
public class String2IntegerEncoder extends MessageToMessageEncoder<String> {
    @Override
    protected void encode(ChannelHandlerContext ctx, String msg, List<Object> out) throws Exception {
        System.out.println("Encoder String: " + msg);
        out.add(Integer.parseInt(msg));
    }
}
