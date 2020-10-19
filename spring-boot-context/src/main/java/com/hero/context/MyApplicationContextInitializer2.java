package com.hero.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @description: MyApplicationContextInitializer2
 * @date: 2020/10/19
 * @author: bear
 * @version: 1.0
 */
public class MyApplicationContextInitializer2 implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }
}
