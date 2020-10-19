package com.hero.context;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * )
 *
 * @date: 2020/10/19
 * @author: bear
 * @version: 1.0
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("Bean count: " + applicationContext.getBeanDefinitionCount());
        //ConfigurableListableBeanFactory configurableListableBeanFactory = applicationContext.getBeanFactory();
    }
}
