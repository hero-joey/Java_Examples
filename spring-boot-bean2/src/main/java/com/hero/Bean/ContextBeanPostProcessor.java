package com.hero.Bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @description: ContextBeanPostProcessor
 * @date: 2020/10/8
 * @author: bear
 * @version: 1.0
 */
@Component
public class ContextBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private ApplicationContext applicationContext;

    //Âß¼­²ÎÕÕApplicationContextAwareProcessor
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MySpringContextAware) {
            MySpringContextAware mySpringContextAware = (MySpringContextAware)bean;
            mySpringContextAware.setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
