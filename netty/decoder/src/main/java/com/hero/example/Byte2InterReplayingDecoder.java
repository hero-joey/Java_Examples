package com.hero.example;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @description: Byte2InterReplayingDecoder
 * @date: 2021/1/8
 * @author: bear
 * @version: 1.0
 */
public class Byte2InterReplayingDecoder extends ReplayingDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        int i = in.readInt();
        System.out.println("解码一个整数: " + i);
        out.add(i);
    }
}
