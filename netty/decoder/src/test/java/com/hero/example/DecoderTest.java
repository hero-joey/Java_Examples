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
public class DecoderTest
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
    public void testDecoder() {

        ChannelInitializer<EmbeddedChannel> channelInitializer = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel embeddedChannel) throws Exception {
                embeddedChannel.pipeline().addLast(new Byte2IntegerDecoder())
                        .addLast(new IntegerProcessHandler());
            }
        };

        EmbeddedChannel embeddedChannel = new EmbeddedChannel(channelInitializer);

        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        for (int i = 0; i < 5; i++) {
            byteBuf.writeInt(i);
        }

        embeddedChannel.writeInbound(byteBuf);

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReplayingDecoder() {

        ChannelInitializer<EmbeddedChannel> channelInitializer = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel embeddedChannel) throws Exception {
                embeddedChannel.pipeline().addLast(new Byte2InterReplayingDecoder())
                        .addLast(new IntegerProcessHandler());
            }
        };

        EmbeddedChannel embeddedChannel = new EmbeddedChannel(channelInitializer);

        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        byteBuf.writeInt(1);
        byteBuf.writeInt(2);
        byteBuf.writeShort(1);
        byteBuf.writeShort(1);

        embeddedChannel.writeInbound(byteBuf);

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIntegerAddDecoder() {

        ChannelInitializer<EmbeddedChannel> channelInitializer = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel embeddedChannel) throws Exception {
                embeddedChannel.pipeline().addLast(new IntegerAddDecoder())
                        .addLast(new IntegerProcessHandler());
            }
        };

        EmbeddedChannel embeddedChannel = new EmbeddedChannel(channelInitializer);

        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        byteBuf.writeInt(1);
        byteBuf.writeInt(2);
        byteBuf.writeInt(2);
        byteBuf.writeInt(3);

        embeddedChannel.writeInbound(byteBuf);

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStringReplayDecoder() {

        ChannelInitializer<EmbeddedChannel> channelInitializer = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel embeddedChannel) throws Exception {
                embeddedChannel.pipeline().addLast(new StringReplayDecoder())
                        .addLast(new StringProcessHandler());
            }
        };

        EmbeddedChannel embeddedChannel = new EmbeddedChannel(channelInitializer);

        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        byteBuf.writeInt(5);
        byteBuf.writeBytes("Hello".getBytes());
        byteBuf.writeInt(5);
        byteBuf.writeBytes("World!".getBytes());
        byteBuf.writeInt(5);
        byteBuf.writeBytes("I am hero".getBytes());

        embeddedChannel.writeInbound(byteBuf);

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStringIntegerHeaderDecoder() {

        ChannelInitializer<EmbeddedChannel> channelInitializer = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel embeddedChannel) throws Exception {
                embeddedChannel.pipeline().addLast(new StringIntegerHeaderDecoder())
                        .addLast(new StringProcessHandler());
            }
        };

        EmbeddedChannel embeddedChannel = new EmbeddedChannel(channelInitializer);

        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        byteBuf.writeInt(5);
        byteBuf.writeBytes("Hello".getBytes());
        byteBuf.writeInt(5);
        byteBuf.writeBytes("World".getBytes());
        byteBuf.writeInt(5);
        byteBuf.writeBytes("I am hero".getBytes());

        embeddedChannel.writeInbound(byteBuf);

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInteger2StringDecoder() {

        ChannelInitializer<EmbeddedChannel> channelInitializer = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel embeddedChannel) throws Exception {
                embeddedChannel.pipeline().addLast(new Byte2IntegerDecoder())
                        .addLast(new Integer2StringDecoder())
                        .addLast(new StringProcessHandler());
            }
        };

        EmbeddedChannel embeddedChannel = new EmbeddedChannel(channelInitializer);

        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        byteBuf.writeInt(5);
        byteBuf.writeInt(10);
        byteBuf.writeInt(15);

        embeddedChannel.writeInbound(byteBuf);

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void LineBasedFrameDecoder() {

        ChannelInitializer<EmbeddedChannel> channelInitializer = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel embeddedChannel) throws Exception {
                embeddedChannel.pipeline().addLast(new LineBasedFrameDecoder(1024))
                        .addLast(new StringDecoder())
                        .addLast(new StringProcessHandler());
            }
        };

        String spliter = "\r\n";
        String content = "疯狂创客圈，高性能Netty编程";

        EmbeddedChannel embeddedChannel = new EmbeddedChannel(channelInitializer);

        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        for (int i = 0; i < 100; i++) {
            int random = i % 5;
            for (int j = 0; j < random; j++) {
                byteBuf.writeBytes(content.getBytes(CharsetUtil.UTF_8));
            }
            byteBuf.writeBytes(spliter.getBytes(CharsetUtil.UTF_8));
        }
        embeddedChannel.writeInbound(byteBuf);

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelimiterBasedFrameDecoder() {

        String spliter = "\t";
        final ByteBuf spliterByteBuf = Unpooled.copiedBuffer(spliter.getBytes(CharsetUtil.UTF_8));

        ChannelInitializer<EmbeddedChannel> channelInitializer = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel embeddedChannel) throws Exception {
                embeddedChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, true, spliterByteBuf))
                        .addLast(new StringDecoder())
                        .addLast(new StringProcessHandler());
            }
        };

        String content = "疯狂创客圈，高性能Netty编程";

        EmbeddedChannel embeddedChannel = new EmbeddedChannel(channelInitializer);

        ByteBuf byteBufContent = ByteBufAllocator.DEFAULT.buffer();
        for (int i = 0; i < 100; i++) {
            int random = i % 5;
            for (int j = 0; j < random; j++) {
                byteBufContent.writeBytes(content.getBytes(CharsetUtil.UTF_8));
            }
            byteBufContent.writeBytes(spliter.getBytes(CharsetUtil.UTF_8));
        }
        embeddedChannel.writeInbound(byteBufContent);

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLengthFieldBasedFrameDecoder() {

        ChannelInitializer<EmbeddedChannel> channelInitializer = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel embeddedChannel) throws Exception {
                embeddedChannel.pipeline().addLast(new LengthFieldBasedFrameDecoder(1024, 0, 4,0 , 4))
                        .addLast(new StringDecoder())
                        .addLast(new StringProcessHandler());
            }
        };

        EmbeddedChannel embeddedChannel = new EmbeddedChannel(channelInitializer);
        ByteBuf byteBufContent = ByteBufAllocator.DEFAULT.buffer();
        for (int i = 0; i < 5; i++) {
            String message = String.format("第%s次发送消息: I am hero zhao", i);
            byteBufContent.writeInt(message.getBytes(CharsetUtil.UTF_8).length);
            byteBufContent.writeBytes(message.getBytes(CharsetUtil.UTF_8));
        }
        embeddedChannel.writeInbound(byteBufContent);

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
