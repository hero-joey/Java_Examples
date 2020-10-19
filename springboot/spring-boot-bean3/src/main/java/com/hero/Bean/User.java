package com.hero.Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @description: User
 * @date: 2020/10/8
 * @author: bear
 * @version: 1.0
 */
//通过component注解构造Bean
@Component
public class User {

    private ApplicationContext applicationContext;

    public User() {
    }

    void init() {
        System.out.println("user init ");
    }

    public void show() {
        System.out.println("user: " + applicationContext);
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        System.out.println("===set===");
    }
}
