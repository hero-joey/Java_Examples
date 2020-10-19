package com.hero.condition;

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
public class ConditionApp {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ConditionApp.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run();
        System.out.println(configurableApplicationContext.getBeansOfType(EncodingConverter.class));
        System.out.println(configurableApplicationContext.getBeansOfType(Runnable.class));
        System.out.println(configurableApplicationContext.getBean("user"));
        System.out.println(configurableApplicationContext.getEnvironment().getProperty("file.encoding"));
        configurableApplicationContext.close();
    }

}
