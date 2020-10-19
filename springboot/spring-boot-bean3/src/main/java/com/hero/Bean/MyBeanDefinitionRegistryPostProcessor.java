package com.hero.Bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * BeanDefinitionRegistryPostProcessor可以拿到BeanDefinitionRegistry/ConfigurableListableBeanFactory两个对象
 * BeanDefinitionRegistry可以动态的注入bean
 * @description: MyBeanDefinitionRegistryPostProcessor
 * @date: 2020/10/11
 * @author: bear
 * @version: 1.0
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {


        for (int i = 0; i < 10; i++) {
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Person.class);
            beanDefinitionBuilder.addPropertyValue("name", "admin" + i);
            registry.registerBeanDefinition("Person" + i, beanDefinitionBuilder.getBeanDefinition());
        }

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
