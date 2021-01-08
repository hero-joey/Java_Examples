package com.hero.example;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @description: StringIntegerHeaderDecoder
 * @date: 2021/1/8
 * @author: bear
 * @version: 1.0
 */
public class StringIntegerHeaderDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }
        in.markReaderIndex();

        int length = in.readInt();
        if (in.readableBytes() < length) {
            in.resetReaderIndex();
            return;
        }

        byte[] bytes = new byte[length];
        in.readBytes(bytes, 0, length);
        out.add(new String(bytes, Charset.defaultCharset()));
    }
}
