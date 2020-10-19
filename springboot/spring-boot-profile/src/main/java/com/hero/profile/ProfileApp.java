package com.hero.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @description: MyBatisApp
 * @date: 2020/9/9 16:05
 * @author: maccura
 * @version: 1.0
 */
@SpringBootApplication
public class ProfileApp {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ProfileApp.class);

        //1.编程方式指定激活生效的配置项，默认配置一定会被加载
        //springApplication.setAdditionalProfiles("test");

        //2.激活方式
        //-命令行：--spring.profiles.active=dev
        //-配置文件：spring.profiles.active=dev
        //-jvm参数:-Dspring.profiles.active=dev
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run();
        System.out.println(configurableApplicationContext.getEnvironment().getProperty("jdbc.url"));
        System.out.println(configurableApplicationContext.getEnvironment().getProperty("jdbc.username"));
        System.out.println(configurableApplicationContext.getEnvironment().getProperty("jdbc.password"));
        //3.可以同时激活多个profile，例如--spring.profiles.active=dev,test，参数不重复


        System.out.println(configurableApplicationContext.getBean("getRunnable2"));
        //4.不同profile可以激活不同的bean，也可以作用于配置类上
       // System.out.println(configurableApplicationContext.getBean("getRunnable3"));

        configurableApplicationContext.close();
    }

}
