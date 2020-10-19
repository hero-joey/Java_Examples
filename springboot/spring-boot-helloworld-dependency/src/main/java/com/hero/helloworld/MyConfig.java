package com.hero.helloworld;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: MyConfig
 * @date: 2020/10/11
 * @author: bear
 * @version: 1.0
 */
//和Configration效果一样，所在包不一样
@SpringBootConfiguration
public class MyConfig {

    @Bean
    public List getList() {
        return new ArrayList();
    }
}
