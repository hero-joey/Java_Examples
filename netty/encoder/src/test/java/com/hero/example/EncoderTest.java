package com.hero.example;

import static org.junit.Assert.assertTrue;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.CharsetUtil;
import org.junit.Test;

import java.util.Random;

/**
 * Unit test for simple App.
 */
public class EncoderTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testIntegerEncoder() {

        ChannelInitializer<EmbeddedChannel> channelInitializer = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel embeddedChannel) throws Exception {
                embeddedChannel.pipeline().addLast(new Integer2BytebufEncoder())
                        .addLast(new Double2BytebufEncoder());
            }
        };

        EmbeddedChannel embeddedChannel = new EmbeddedChannel(channelInitializer);

        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        for (int i = 0; i < 3; i++) {
            embeddedChannel.write(i);
        }

        embeddedChannel.write(3.14);
        embeddedChannel.write(2.25);
        embeddedChannel.write(9.12);

        embeddedChannel.flushOutbound();


        for (int i = 0; i < 3; i++) {
            ByteBuf byteBufRead = embeddedChannel.readOutbound();
            int integer = byteBufRead.readInt();
            System.out.println("Read Integer: " + integer);
        }

        for (int i = 0; i < 3; i++) {
            ByteBuf byteBufRead = embeddedChannel.readOutbound();
            double d = byteBufRead.readDouble();
            System.out.println("Read Double: " + d);
        }

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testString2IntegerEncoder() {

        ChannelInitializer<EmbeddedChannel> channelInitializer = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel embeddedChannel) throws Exception {
                embeddedChannel.pipeline().addLast(new Integer2BytebufEncoder())
                        .addLast(new String2IntegerEncoder());
            }
        };

        EmbeddedChannel embeddedChannel = new EmbeddedChannel(channelInitializer);

        embeddedChannel.write("123");
        embeddedChannel.write("1234");
        embeddedChannel.write("12345");
        embeddedChannel.flushOutbound();

        for (int i = 0; i < 3; i++) {
            ByteBuf byteBufRead = embeddedChannel.readOutbound();
            int integer = byteBufRead.readInt();
            System.out.println("Read Integer: " + integer);
        }

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
