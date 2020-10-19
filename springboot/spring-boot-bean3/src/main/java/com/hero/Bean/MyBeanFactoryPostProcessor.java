package com.hero.Bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * BeanFactoryPostProcessor在spring容器初始化之后触发，而且只会触发一次
 * 触发时机比BeanPostProcessor早
 * @description: MyBeanFactoryPostProcessor
 * @date: 2020/10/9
 * @author: bear
 * @version: 1.0
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("======" + beanFactory.getBeanDefinitionCount());
    }
}
