package com.hero.example;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @description: Byte2IntegerDecoder
 * @date: 2021/1/7
 * @author: bear
 * @version: 1.0
 */
public class Byte2IntegerDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        while (in.readableBytes() >= 4) {
            int i = in.readInt();
            System.out.println("解析出一个整数: " + i);
            out.add(i);
        }
    }
}
