package com.hero.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: MyBatisApp
 * @date: 2020/9/9 16:05
 * @author: maccura
 * @version: 1.0
 */
@SpringBootApplication
@MapperScan("com.hero.mybatis.dao")
public class MyBatisApp {
    public static void main(String[] args) {
        SpringApplication.run(MyBatisApp.class, args);
    }
}
