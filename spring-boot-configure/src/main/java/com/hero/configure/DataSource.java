package com.hero.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description: DataSource
 * @date: 2020/10/12
 * @author: bear
 * @version: 1.0
 */
@ConfigurationProperties(prefix = "ds")
@Component
public class DataSource {
    private String url;
    private String driverClassName;
    private String username;
    private String password;

    public DataSource() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void show() {
        System.out.println("======DataSourceProperties======");
        System.out.println("ds.url: " + url);
        System.out.println("ds.driverClasName:" + driverClassName);
        System.out.println("ds.userName: " + username);
        System.out.println("ds.userAge: " + password);
    }
}
