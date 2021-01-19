package com.hero.chatroom.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.StaticApplicationContext;

/**
 * @description: ChatClientApp
 * @date: 2021/1/18
 * @author: bear
 * @version: 1.0
 */

@SpringBootApplication
public class ChatClientApp {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ChatClientApp.class);
        ApplicationContext applicationContext = springApplication.run(args);
        ChatClient chatClient = applicationContext.getBean(ChatClient.class);
        chatClient.start();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
