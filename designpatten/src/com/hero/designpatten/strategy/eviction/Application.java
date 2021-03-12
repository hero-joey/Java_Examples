package com.hero.designpatten.strategy.eviction;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @description: Application
 * @date: 2021/3/12 11:10
 * @author: maccura
 * @version: 1.0
 */
public class Application {
    public static void main(String[] args) throws IOException {
        EvictionStrategy evictionStrategy = null;
        Properties properties = new Properties();
        properties.load(new FileInputStream("./config.properties"));
        String type = properties.getProperty("eviction_type");
        evictionStrategy = EvictionStrategyFactory.getStrategy(type);

        //运行时动态确定，根据配置文件的配置决定使用哪种策略
        UserCache userCache = new UserCache(evictionStrategy);
    }
}
