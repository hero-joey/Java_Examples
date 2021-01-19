package com.hero.chatroom.client;

import com.hero.chatroom.biz.ClientSession;
import com.hero.chatroom.client.command.BaseCommand;
import com.hero.chatroom.common.ExecuteTask;
import com.hero.chatroom.common.FutureTaskScheduler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoop;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @description: ChatClient
 * @date: 2021/1/18
 * @author: bear
 * @version: 1.0
 */

@Component
public class ChatClient {

    private final NettyClient nettyClient;
    private ClientSession clientSession;
    private Boolean connectFlag = false;

    private CommandRegistry commandRegistry;

    @Autowired
    public ChatClient(NettyClient nettyClient, CommandRegistry commandRegistry) {
        this.nettyClient = nettyClient;
        this.commandRegistry = commandRegistry;
    }

    GenericFutureListener<ChannelFuture> closedListener = new GenericFutureListener<ChannelFuture>() {
        @Override
        public void operationComplete(ChannelFuture future) throws Exception {
            System.out.println( new Date() + "连接断开");
            Channel channel = future.channel();
            ClientSession clientSession = channel.attr(ClientSession.sessionAttributeKey).get();
            clientSession.close();
        }
    };

    GenericFutureListener<ChannelFuture> connectedListener = new GenericFutureListener<ChannelFuture>() {
        @Override
        public void operationComplete(ChannelFuture future) throws Exception {
            EventLoop eventLoop = future.channel().eventLoop();
            if (!future.isSuccess()) {
                System.out.println("连接失败，客户端将在10S后重新连接");
                eventLoop.schedule(new Runnable() {
                    @Override
                    public void run() {
                        nettyClient.connectToServer();
                        System.out.println();
                    }
                }, 10, TimeUnit.SECONDS);
                connectFlag = false;

            } else {
                connectFlag = true;
                Channel channel = future.channel();
                clientSession = new ClientSession(channel, true);
                channel.closeFuture().addListener(closedListener);
            }
        }
    };

    public void startConnectToServer() {
        FutureTaskScheduler.addTask(new ExecuteTask() {
            @Override
            public void execute() {
                nettyClient.setConnectedListener(connectedListener);
                nettyClient.connectToServer();
            }
        });
    }

    private synchronized void waitConnectSuccess() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() {

        while (!connectFlag) {
            startConnectToServer();
            waitConnectSuccess();
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请输入你的请求:");
            commandRegistry.printCommandTable();

            String commandKey = scanner.next();
            BaseCommand baseCommand = commandRegistry.getCommand(commandKey);
            if (baseCommand != null) {
                baseCommand.parse(scanner);
            }
        }


    }


}
