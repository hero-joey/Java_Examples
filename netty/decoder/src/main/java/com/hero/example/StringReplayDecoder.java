package com.hero.example;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @description: StringReplayDecoder
 * @date: 2021/1/8
 * @author: bear
 * @version: 1.0
 */
public class StringReplayDecoder extends ReplayingDecoder<StringReplayDecoder.Status> {
    enum Status {
        PARSE_1,
        PARSE_2
    };

    private int length;
    private byte[] bytes;

    public StringReplayDecoder() {
        super(Status.PARSE_1);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        switch (state()) {
            case PARSE_1:
                length = in.readInt();
                bytes = new byte[length];
                checkpoint(Status.PARSE_2);
                break;
            case PARSE_2:
                in.readBytes(bytes, 0, length);
                out.add(new String(bytes, CharsetUtil.UTF_8));
                checkpoint(Status.PARSE_1);
                break;
            default:
                break;
        }
    }
}
