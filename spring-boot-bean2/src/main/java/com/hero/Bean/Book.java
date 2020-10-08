package com.hero.Bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description: Book
 * @date: 2020/10/8
 * @author: bear
 * @version: 1.0
 */

@Component
public class Book implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void show() {
        System.out.println("Book: " + applicationContext);
    }
}
