package com.hero.echoserver.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.util.Scanner;

public class EchoClient {
    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start()
        throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                .channel(NioSocketChannel.class)
                .remoteAddress(new InetSocketAddress(host, port))
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch)
                        throws Exception {
                        ch.pipeline().addLast(
                             new EchoClientHandler());
                    }
                });
            ChannelFuture channelFuture = b.connect().sync().addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (future.isSuccess()) {
                        System.out.println("连接服务器成功");
                    } else {
                        System.out.println("连接服务器失败，请重试");
                    }

                }
            });
            Channel channel = channelFuture.channel();
            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNext()) {
                String message = scanner.next();
                ByteBuf byteBuf = channel.alloc().buffer();
                byteBuf.writeBytes(message.getBytes());

                channel.writeAndFlush(byteBuf);

            }

            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args)
            throws Exception {
        final String host = "127.0.0.1";
        final int port = 8080;
        new EchoClient(host, port).start();
    }
}

