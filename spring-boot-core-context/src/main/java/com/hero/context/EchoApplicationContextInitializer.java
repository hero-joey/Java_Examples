package com.hero.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @description: EchoApplicationContextInitializer
 * @date: 2020/10/19
 * @author: bear
 * @version: 1.0
 */
public class EchoApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("====EchoApplicationContextInitializer====");
    }
}
