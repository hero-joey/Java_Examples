package com.hero.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: FirstInitialiser
 * @date: 2020/9/24
 * @author: bear
 * @version: 1.0
 */
@Order(1)
public class FirstInitialiser implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        ConfigurableEnvironment configurableEnvironment = configurableApplicationContext.getEnvironment();

        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");

        MapPropertySource mapPropertySource = new MapPropertySource("firstInitialiser", map);
        configurableEnvironment.getPropertySources().addLast(mapPropertySource);
        System.out.println("firstInitialiser");
    }
}
