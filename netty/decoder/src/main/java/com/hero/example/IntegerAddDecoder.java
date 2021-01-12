package com.hero.example;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @description: IntegerAddDecodeder
 * @date: 2021/1/8
 * @author: bear
 * @version: 1.0
 */
public class IntegerAddDecoder extends ReplayingDecoder<IntegerAddDecoder.Status> {

    enum Status {
        PARSE_1,
        PARSE_2
    }

    private int first;
    private int second;

    public IntegerAddDecoder() {
        super(Status.PARSE_1);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        switch (state()) {
            case PARSE_1:
                first = in.readInt();
                checkpoint(Status.PARSE_2);
                break;
            case PARSE_2:
                second = in.readInt();
                checkpoint(Status.PARSE_1);
                int sum = first + second;
                out.add(sum);
                break;
            default:
                break;
        }
    }
}
