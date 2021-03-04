package com.hero.di;

/**
 * @description: NoSuchBeanDefinitionException
 * @date: 2021/3/4 13:33
 * @author: maccura
 * @version: 1.0
 */
public class NoSuchBeanDefinitionException extends RuntimeException {
    public NoSuchBeanDefinitionException(String message) {
        super(message);
    }
}
