package com.hero.profile;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * @description: MyConfig
 * @date: 2020/10/13
 * @author: bear
 * @version: 1.0
 */
@SpringBootConfiguration
public class MyConfig {
    @Bean
    public Runnable getRunnable() {
        System.out.println("=====getRunnable=====");
        return () -> {};
    }

    //profile为test环境激活该bean
    @Bean
    @Profile("test")
    public Runnable getRunnable2() {
        System.out.println("=====getRunnable2=====");
        return () -> {};
    }

    //profile为dev环境激活该bean
    @Bean
    @Profile("dev")
    public Runnable getRunnable3() {
        System.out.println("=====getRunnable3=====");
        return () -> {};
    }
}
