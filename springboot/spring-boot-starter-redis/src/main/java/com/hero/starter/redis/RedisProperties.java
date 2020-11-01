package com.hero.starter.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description: RedisProperties
 * @date: 2020/11/1
 * @author: bear
 * @version: 1.0
 */
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {
    private String host;
    private Integer port;
    private String password;

    public RedisProperties() {
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
