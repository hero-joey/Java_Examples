package com.hero.test;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @description: TestBeanConfiguration
 * @date: 2020/11/9
 * @author: bear
 * @version: 1.0
 */
@TestConfiguration
public class TestBeanConfiguration {

    @Bean
    public Runnable getRunnale() {
        return () -> {
            System.out.println("Hello World");
        };
    }
}
