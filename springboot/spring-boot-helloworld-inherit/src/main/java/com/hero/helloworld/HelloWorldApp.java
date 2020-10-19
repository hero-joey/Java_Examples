package com.hero.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @description: MyBatisApp
 * @date: 2020/9/9 16:05
 * @author: maccura
 * @version: 1.0
 */
@SpringBootApplication
public class HelloWorldApp {

    @Bean
    Runnable getRunnable() {
        return () -> {System.out.println("Spring boot is starting!"); };
    }
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(HelloWorldApp.class, args);
        applicationContext.getBean(Runnable.class).run();
        ((ConfigurableApplicationContext) applicationContext).close();
    }
}
