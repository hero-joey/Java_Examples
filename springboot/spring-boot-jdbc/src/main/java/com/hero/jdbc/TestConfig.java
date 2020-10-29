package com.hero.jdbc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description: TestConfig
 * @date: 2020/10/29
 * @author: bear
 * @version: 1.0
 */

@Component
public class TestConfig {
    @Value("${spring.datasource.username}")
    private String password;

    public TestConfig() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TestConfig{" +
                "password='" + password + '\'' +
                '}';
    }
}
