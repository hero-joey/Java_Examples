package com.hero.configure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @description: MyBatisApp
 * @date: 2020/9/9 16:05
 * @author: maccura
 * @version: 1.0
 */
@SpringBootApplication
public class ConfigureApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ConfigureApp.class, args);
        System.out.println(configurableApplicationContext.getEnvironment().getProperty("local.ip"));
        configurableApplicationContext.getBean(UserConfig.class).show();
        configurableApplicationContext.getBean(JdbcConfig.class).show();
        configurableApplicationContext.getBean(DataSource.class).show();
        configurableApplicationContext.getBean(RedisConfig.class).show();

    }

    //启动时设置参数修改配置文件application.properties的名字 --spring.config.name=app

}
