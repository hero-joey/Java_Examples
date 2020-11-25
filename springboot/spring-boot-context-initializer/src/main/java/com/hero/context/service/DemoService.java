package com.hero.context.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @description: DemoService
 * @date: 2020/11/22
 * @author: bear
 * @version: 1.0
 */
@Service
public class DemoService  {
    private  Environment environment;

    @Autowired
    public DemoService(Environment environment) {
        this.environment = environment;
    }

    public String getProperty(String propertyName) {
        return environment.getProperty(propertyName);
    }
}
