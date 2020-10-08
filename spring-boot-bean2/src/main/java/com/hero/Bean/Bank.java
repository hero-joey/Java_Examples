package com.hero.Bean;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @description: Bank
 * @date: 2020/10/8
 * @author: bear
 * @version: 1.0
 */

@Component
public class Bank {
    private ApplicationContext applicationContext;

    //spring4.3新特性，会自动注入，不需要autowire注解
    public Bank(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    void show() {
        System.out.println("Bank: " + applicationContext);
    }
}
