package com.hero.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: RunnableConfiguration
 * @date: 2020/10/19
 * @author: bear
 * @version: 1.0
 */
@Configuration
public class RunnableConfiguration {

    @Bean
    public Runnable createRunnable() {
        return () -> {
        };
    }
}
