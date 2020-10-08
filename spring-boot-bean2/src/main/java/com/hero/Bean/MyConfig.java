package com.hero.Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: MyConfig
 * @date: 2020/10/8
 * @author: bear
 * @version: 1.0
 */
@Configuration
public class MyConfig {
    //通过Bean注解构造user Bean
    @Bean(initMethod = "init")
    public User getUser() {
        return new User();
    }
}
