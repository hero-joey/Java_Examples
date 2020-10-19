package com.hero.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @description: RedisConfig
 * @date: 2020/10/12
 * @author: bear
 * @version: 1.0
 */
@Component
@ConfigurationProperties(prefix = "redis")
@PropertySource("classpath:redis.properties")
public class RedisConfig {
    private String name;
    private String localhost;

    public RedisConfig() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalhost() {
        return localhost;
    }

    public void setLocalhost(String localhost) {
        this.localhost = localhost;
    }

    void show() {
        System.out.println("======redisProperties======");
        System.out.println("name: " + name);
        System.out.println("localhost:" + localhost);
    }
}
