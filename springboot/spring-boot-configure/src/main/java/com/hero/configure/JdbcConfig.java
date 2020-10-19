package com.hero.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description: JdbcConfig
 * @date: 2020/10/12
 * @author: bear
 * @version: 1.0
 */
@Component
public class JdbcConfig {
    @Value("${url}")
    private String url;
    @Value("${driverClassName}")
    private String driverClassName;

    @Value("${username}")
    private String userName;

    @Value("${userage}")
    private Integer userAge;


    public JdbcConfig() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public void show() {
        System.out.println("======jdbcProperties======");
        System.out.println("url: " + url);
        System.out.println("driverClasName:" + driverClassName);
        System.out.println("userName: " + userName);
        System.out.println("userAge: " + userAge);
    }
}
