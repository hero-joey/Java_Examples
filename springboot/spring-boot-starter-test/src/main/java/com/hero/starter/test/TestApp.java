package com.hero.starter.test;

import com.hero.starter.redis.EnableRedis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import redis.clients.jedis.Jedis;

/**
 * @description: TestApp
 * 自定义starter的步骤
 * 1.新建一个项目
 * 2.指定配置类，配置类里面提供需要提供出的消息
 * 3.使用一个注解，Enable*导入需要配置得类, 或者在spring.factories文件中org.springframework.boot.autoconfigure.EnableAutoConfiguration=定义需要自动配置类的类
 * @date: 2020/11/1
 * @author: bear
 * @version: 1.0
 */
@SpringBootApplication
//@EnableRedis
public class TestApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = new SpringApplication(TestApp.class).run(args);
        System.out.println(configurableApplicationContext.getBean(Jedis.class));

        Jedis jedis = configurableApplicationContext.getBean(Jedis.class);
        jedis.set("name", "HeroJoy");
        System.out.println(jedis.get("name"));
        configurableApplicationContext.close();
    }
}
