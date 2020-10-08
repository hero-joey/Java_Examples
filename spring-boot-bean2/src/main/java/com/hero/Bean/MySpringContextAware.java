package com.hero.Bean;

import org.springframework.context.ApplicationContext;

/**
 * @description: MySpringContextAware
 * @date: 2020/10/8
 * @author: bear
 * @version: 1.0
 */
public interface MySpringContextAware {
    void setApplicationContext(ApplicationContext applicationContext);
}
