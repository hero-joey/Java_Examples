package com.hero.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @description: FileConfig
 * @date: 2020/10/12
 * @author: bear
 * @version: 1.0
 */
@Configuration
//PropertySource可以加载一个外部的配置
//PropertySource可以加载多个外部的配置
@PropertySource("classpath:jdbc.properties")
@PropertySource("file:/F:/user.properties")
public class FileConfig {
}
