package com.hero.Bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @description: Dog
 * @date: 2020/10/8
 * @author: bear
 * @version: 1.0
 */

@Component
public class Dog implements MySpringContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    void show() {
        System.out.println("Dog: " + applicationContext);
    }
}
