package com.hero.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

/**
 * @description: ByteBufTypeTest
 * @date: 2021/1/6
 * @author: bear
 * @version: 1.0
 */
public class ByteBufTypeTest {

    @Test
    public void testHeapByteBuf() {
        ByteBuf heapByteBuf = ByteBufAllocator.DEFAULT.heapBuffer();
        heapByteBuf.writeBytes("Hi,I am hero!".getBytes());
        if (heapByteBuf.hasArray()) {
            System.out.println("Heap bytebuf");
            byte[] bytes = heapByteBuf.array();
            int offset = heapByteBuf.arrayOffset() + heapByteBuf.readerIndex();
            int length = heapByteBuf.readableBytes();
            System.out.println(new String(bytes, offset, length));
            heapByteBuf.release();
        } else {
            System.out.println("direct bytebuf");
        }
    }

    @Test
    public void testDirectByteBuf() {
        ByteBuf directByteBuf = ByteBufAllocator.DEFAULT.directBuffer();
        directByteBuf.writeBytes("Hi,I am hero!".getBytes());
        if (directByteBuf.hasArray()) {
            System.out.println("Heap bytebuf");
        } else {
            int length = directByteBuf.readableBytes();

            byte[] array = new byte[length];
            directByteBuf.getBytes(directByteBuf.readerIndex(), array);
            System.out.println(new String(array));
            System.out.println("direct bytebuf");
        }
    }

    private void sendMsg(CompositeByteBuf compositeByteBuf) {
        //处理整个消息
        for (ByteBuf byteBuf : compositeByteBuf) {
            int length = byteBuf.readableBytes();
            byte[] array = new byte[length];
            //将CompositeByteBuf中的数据复制到数组中
            byteBuf.getBytes(byteBuf.readerIndex(), array);
            //处理一下数组中的数据
            System.out.print(new String(array));
        }
        System.out.println();
    }

    public void testCompositeByteBuf() {
        CompositeByteBuf compositeByteBuf = ByteBufAllocator.DEFAULT.compositeBuffer();
        ByteBuf headBuf = Unpooled.copiedBuffer("疯狂创客圈".getBytes());
        ByteBuf bodyBuf = Unpooled.copiedBuffer("Netty实战".getBytes());

        compositeByteBuf.addComponents(headBuf, bodyBuf);
    }
}
