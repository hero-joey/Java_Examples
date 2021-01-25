package com.hero.context;

import com.hero.context.initializer.SecondContextInitializer;
import com.hero.listener.SecondListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

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
        springApplication.addListeners(new SecondListener());

        System.out.println(ArrayList.class.isAssignableFrom(List.class));
        System.out.println(List.class.isAssignableFrom(ArrayList.class));

        springApplication.run(args);
    }
}
