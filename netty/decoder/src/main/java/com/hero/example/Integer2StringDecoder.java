package com.hero.example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * @description: Integer2StringDecoder
 * @date: 2021/1/8
 * @author: bear
 * @version: 1.0
 */
public class Integer2StringDecoder extends MessageToMessageDecoder<Integer> {
    @Override
    protected void decode(ChannelHandlerContext ctx, Integer msg, List<Object> out) throws Exception {
        System.out.println("Integer2String: " + String.valueOf(msg));
        out.add(String.valueOf(msg));
    }
}
