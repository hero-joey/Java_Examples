package com.hero.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: UserConfiguration
 * @date: 2020/10/13
 * @author: bear
 * @version: 1.0
 */
@Configuration
class UserConfiguration {

    @Bean
    //根据某个属性存在时装配类
    //matchIfMissing配置不存在时，如何处理
    @ConditionalOnProperty(name = "runnable.enable", havingValue = "true")
    public Runnable createRunnable() {
        return () -> {
            System.out.println("Hello, runnable");
        };
    }

    //根据某个类存在时装配类
    @Bean
    @ConditionalOnMissingClass("com.hero.condition.Gson")
    public Runnable createGsonRunnable() {
        return () -> {
            System.out.println("Gson, Runnable");
        };
    }

    //根据某个bean存在时装配类
    @Bean
    @ConditionalOnBean(name = "user")
    public Runnable createBeanRunnable() {
        return () -> {
            System.out.println("Bean, Runnable");
        };
    }
}
