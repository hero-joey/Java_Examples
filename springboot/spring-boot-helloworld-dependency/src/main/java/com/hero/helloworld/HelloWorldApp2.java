package com.hero.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

/**
 * @description: HelloWorldApp2
 * @date: 2020/10/11
 * @author: bear
 * @version: 1.0
 */
@ComponentScan
public class HelloWorldApp2 {
    @Bean
    Runnable getRunnable() {
        return () -> {
            System.out.println("Spring boot is starting!");
        };
    }


}
