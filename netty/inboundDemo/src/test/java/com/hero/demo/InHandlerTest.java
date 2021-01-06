package com.hero.demo;

import static org.junit.Assert.assertTrue;

import com.hero.demo.handler.*;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class InHandlerTest
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
    public void testInHandler() {
        final InHandler inHandler= new InHandler();
        ChannelInitializer<EmbeddedChannel> channelChannelInitializer = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel embeddedChannel) throws Exception {
                //embeddedChannel.pipeline().addLast(inHandler);
                embeddedChannel.pipeline().addLast(new SimpleInBoundHandlerA());
                embeddedChannel.pipeline().addLast(new SimpleInBoundHandlerB());
                embeddedChannel.pipeline().addLast(new SimpleInBoundHandlerC());

            }
        };

        EmbeddedChannel embeddedChannel = new EmbeddedChannel(channelChannelInitializer);
        ByteBuf byteBuf = Unpooled.buffer();
        byteBuf.writeInt(1);
        embeddedChannel.writeInbound(byteBuf);
        embeddedChannel.flush();

        embeddedChannel.writeInbound(byteBuf);
        embeddedChannel.flush();
        embeddedChannel.close();

        System.out.println("bytebuf refCnt: " + byteBuf.refCnt());
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOutHandler() {
        final InHandler inHandler= new InHandler();
        ChannelInitializer<EmbeddedChannel> channelChannelInitializer = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel embeddedChannel) throws Exception {
                //embeddedChannel.pipeline().addLast(inHandler);
                embeddedChannel.pipeline().addLast(new SimpleOutBoundHandlerA());
                embeddedChannel.pipeline().addLast(new SimpleOutBoundHandlerB());
                embeddedChannel.pipeline().addLast(new SimpleOutBoundHandlerC());

            }
        };

        EmbeddedChannel embeddedChannel = new EmbeddedChannel(channelChannelInitializer);
        ByteBuf byteBuf = Unpooled.buffer();
        byteBuf.writeInt(1);
        embeddedChannel.writeOutbound(byteBuf);
        embeddedChannel.flush();

        System.out.println("bytebuf refCnt: " + byteBuf.refCnt());
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
