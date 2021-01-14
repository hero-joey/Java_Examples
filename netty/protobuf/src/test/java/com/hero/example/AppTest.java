package com.hero.example;

import static org.junit.Assert.assertTrue;

import com.google.protobuf.InvalidProtocolBufferException;
import com.hero.example.protocol.MsgProtos;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest 
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
    public void testProtobuf1() throws IOException {
        MsgProtos.Msg.Builder builder = MsgProtos.Msg.newBuilder();
        builder.setId(0);
        builder.setContent("Hello world");

        MsgProtos.Msg message = builder.build();
        byte[] bytes = message.toByteArray();
        System.out.println("Seriliser: " + bytes.toString());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(bytes);
        bytes = byteArrayOutputStream.toByteArray();

        message = MsgProtos.Msg.parseFrom(bytes);
        System.out.println(message.getId());
        System.out.println(message.getContent());

    }

    @Test
    public void testProtobuf2() throws IOException {
        MsgProtos.Msg.Builder builder = MsgProtos.Msg.newBuilder();
        builder.setId(1);
        builder.setContent("Hero");
        MsgProtos.Msg message = builder.build();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        message.writeTo(byteArrayOutputStream);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        message = MsgProtos.Msg.parseFrom(byteArrayInputStream);
        System.out.println(message.getId());
        System.out.println(message.getContent());
    }

    /**  writeDelimitedTo  parseDelimitedFrom解决了黏包、半包问题
     * @description:
     * @param: []
     * @return: void
     * @auther: 6324/heroJoy
     * @date: 2021/1/13 11:23
     */
    @Test
    public void testProtobuf3() throws IOException {
        MsgProtos.Msg.Builder builder = MsgProtos.Msg.newBuilder();
        builder.setId(2);
        builder.setContent("Jack");
        MsgProtos.Msg message = builder.build();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        message.writeDelimitedTo(byteArrayOutputStream);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        message = MsgProtos.Msg.parseDelimitedFrom(byteArrayInputStream);
        System.out.println(message.getId());
        System.out.println(message.getContent());
    }
}
