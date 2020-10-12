package com.hero.configure2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @description: MyBatisApp
 * @date: 2020/9/9 16:05
 * @author: maccura
 * @version: 1.0
 */
@SpringBootApplication
public class ConfigureApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ConfigureApp.class, args);
        System.out.println(configurableApplicationContext.getEnvironment().getProperty("jdbc.username"));
        System.out.println(configurableApplicationContext.getEnvironment().getProperty("jdbc.password"));
        System.out.println(configurableApplicationContext.getBean(TomcatProperties.class));
        System.out.println(configurableApplicationContext.getEnvironment().getProperty("clientname"));
        System.out.println(configurableApplicationContext.getEnvironment().getProperty("clientage"));
        configurableApplicationContext.close();
    }

}
