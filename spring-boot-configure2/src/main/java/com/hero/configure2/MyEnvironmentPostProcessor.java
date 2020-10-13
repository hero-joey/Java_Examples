package com.hero.configure2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @description: MyEnvironmentPostProcessor
 * @date: 2020/10/12
 * @author: bear
 * @version: 1.0
 */
@Component
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

        //配置文件集中化管理，也可以参照该种方式实现
        try (InputStream inputStream = new FileInputStream("F://user.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource("MyProperties", properties);
            environment.getPropertySources().addLast(propertiesPropertySource);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
