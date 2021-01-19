package com.hero.chatroom.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.util.concurrent.GenericFutureListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @description: NettyClient
 * @date: 2021/1/18
 * @author: bear
 * @version: 1.0
 */
@Component
public class NettyClient {
    @Value("${chatroom.server}")
    private String serverIp;

    @Value("${chatroom.port}")
    private Integer serverPort;
    private EventLoopGroup eventLoopGroup;

    private GenericFutureListener<ChannelFuture> connectedListener;

    public NettyClient() {
        this.eventLoopGroup = new NioEventLoopGroup();
    }

    public void setConnectedListener(GenericFutureListener<ChannelFuture> connectedListener) {
        this.connectedListener = connectedListener;
    }

    public void connectToServer() {
        Bootstrap bootstrap = new Bootstrap();

        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .remoteAddress(serverIp, serverPort)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ProtobufEncoder());
                    }
                });

        bootstrap.connect().addListener(connectedListener);
    }


}
