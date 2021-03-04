package com.hero.di;

/**
 * @description: ApplicationContext
 * @date: 2021/3/4 13:21
 * @author: maccura
 * @version: 1.0
 */
public interface ApplicationContext {
    Object getBean(String beanId);
}
