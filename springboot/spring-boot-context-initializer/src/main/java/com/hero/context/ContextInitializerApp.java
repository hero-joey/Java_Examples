package com.hero.context;

import com.hero.context.initializer.SecondContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: MyBatisApp
 * @date: 2020/9/9 16:05
 * @author: maccura
 * @version: 1.0
 */
@SpringBootApplication
public class ContextInitializerApp {
    public static void main(String[] args) {
        //SpringApplication.run(ContextInitializerApp.class, args);
        SpringApplication springApplication = new SpringApplication(ContextInitializerApp.class);
        springApplication.addInitializers(new SecondContextInitializer());
        springApplication.run(args);
    }
}
