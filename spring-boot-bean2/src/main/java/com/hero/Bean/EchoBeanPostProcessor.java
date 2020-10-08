package com.hero.Bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * BeanPostProcessor会在每个bean初始化的时候，调用一次
 * 不能返回null，否则从容器中就获取不到
 * @description: EchoBeanPostProcessor
 * @date: 2020/10/8
 * @author: bear
 * @version: 1.0
 */

@Component
public class EchoBeanPostProcessor implements BeanPostProcessor {
    //是在bean依赖装配(属性设置，例如set)完成之后触发
    //这里可以对指定的Bean做一些处理，比如说返回该对象的代理对象
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("======postProcessBeforeInitialization======" + bean.getClass());

        if (bean instanceof User) {
            return new LogUser();
        }
        return bean;
    }


    //是在bean init方法之后触发的
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("======postProcessAfterInitialization======"  + bean.getClass());
        return bean;
    }
}
