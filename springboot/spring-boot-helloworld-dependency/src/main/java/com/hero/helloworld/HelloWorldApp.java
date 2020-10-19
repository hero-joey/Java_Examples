package com.hero.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * @description: MyBatisApp
 * @date: 2020/9/9 16:05
 * @author: maccura
 * @version: 1.0
 */
//@SpringBootApplication
//可以简化成componentscan

public class HelloWorldApp {

    public static void main(String[] args) {
        //.run(XXX.class)会被装配成一个装配类Configuration
        ApplicationContext applicationContext = SpringApplication.run(HelloWorldApp2.class, args);
        applicationContext.getBean(Runnable.class).run();
        System.out.println(applicationContext.getBean(User.class));
        System.out.println(applicationContext.getBean(List.class));
        ((ConfigurableApplicationContext) applicationContext).close();
    }


}
