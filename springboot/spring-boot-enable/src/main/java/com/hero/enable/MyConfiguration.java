package com.hero.enable;

import org.springframework.context.annotation.Bean;

/**
 * @description: MyConfiguration
 * @date: 2020/10/14
 * @author: bear
 * @version: 1.0
 */
public class MyConfiguration {


    @Bean
    Runnable createRunnable1() {
        return () -> {};
    }

    @Bean
    Runnable createRunnable2() {
        return () -> {};
    }

}
