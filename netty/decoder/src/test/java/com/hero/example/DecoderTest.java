package com.hero.example;

import static org.junit.Assert.assertTrue;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Test;

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
}
