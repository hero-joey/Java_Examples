package com.hero.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @description: MonitorApp
 * @date: 2020/9/9 16:05
 * @author: maccura
 * @version: 1.0
 */
@SpringBootApplication
public class TestApp {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TestApp.class);

        ConfigurableApplicationContext configurableApplicationContext = springApplication.run();
        System.out.println(configurableApplicationContext);
        //configurableApplicationContext.close();
    }



}


