package com.hero.context.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: FirstContextInitialiser
 * @date: 2020/11/22
 * @author: bear
 * @version: 1.0
 */
@Order(1)
public class ThirdContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment configurableEnvironment = applicationContext.getEnvironment();
        Map<String, Object>  propertyMap = new HashMap<>();
        propertyMap.put("key3", "value3");

        MapPropertySource mapPropertySource = new MapPropertySource("thirdContextInitializer", propertyMap);
        configurableEnvironment.getPropertySources().addLast(mapPropertySource);
        System.out.println("Third Initializer");
    }
}
