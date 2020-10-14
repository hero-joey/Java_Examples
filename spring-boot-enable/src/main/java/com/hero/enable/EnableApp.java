package com.hero.enable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @description: MyBatisApp
 * @date: 2020/9/9 16:05
 * @author: maccura
 * @version: 1.0
 */
//1.可以使用@SpringBootApplication
//2.可以使用
//@EnableAutoConfiguration
//@ComponentScan
//3.真正起作用的是EnableConfigurationProperties,是用来启动用一个特性的，这个特性就是可以把配置文件的属性注入到bean里面，一般和
    //ConfigurationProperties
    @ComponentScan
    @EnableConfigurationProperties
    //启用异步，一般是和Async一起使用
    @EnableAsync

    //Import用来导入一个或多个类(会被spring容器托管), 或者配置类(配置类所有的bean都会被spring容器托管)
    @Import({User.class, Role.class, MyConfiguration.class})

    //MyImportSelector
public class EnableApp {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(EnableApp.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run();
        System.out.println(configurableApplicationContext.getBean(TomcatProperties.class));
        //configurableApplicationContext.getBean(Runnable.class).run();
        System.out.println(configurableApplicationContext.getBeansOfType(Runnable.class));
        System.out.println(configurableApplicationContext.getBean(User.class));
        System.out.println(configurableApplicationContext.getBean(Role.class));

        System.out.println("===end===");
        configurableApplicationContext.close();
    }

}
