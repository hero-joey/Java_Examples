package com.hero.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @description: DruidConfig
 * @date: 2020/10/29
 * @author: bear
 * @version: 1.0
 */
@Configuration
public class DruidConfig {

    private Environment environment;

    @Autowired
    public DruidConfig(Environment environment) {
        this.environment = environment;
    }

    //springboot默认优先使用自己的配置
    @Bean
    DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(environment.getProperty("spring.datasource.url"));
        druidDataSource.setUsername(environment.getProperty("spring.datasource.username"));
        druidDataSource.setPassword(environment.getProperty("spring.datasource.password"));
        druidDataSource.setDriverClassName(environment.getProperty("driver-class-name"));
        return druidDataSource;
    }
}
