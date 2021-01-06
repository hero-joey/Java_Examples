package com.hero.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.junit.Test;

/**
 * @description: ReferenceTest
 * @date: 2021/1/6
 * @author: bear
 * @version: 1.0
 */
public class ReferenceTest {

    @Test
    public void testBuf() {
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        System.out.println("After create, byte buf refcnt: " + byteBuf.refCnt());

        byteBuf.retain();
        System.out.println("After retain, byte buf refcnt: " + byteBuf.refCnt());

        byteBuf.release();
        System.out.println("After release, byte buf refcnt: " + byteBuf.refCnt());

        byteBuf.release();
        System.out.println("After release, byte buf refcnt: " + byteBuf.refCnt());

        byteBuf.retain();
        System.out.println("After retain, byte buf refcnt: " + byteBuf.refCnt());
    }
}
