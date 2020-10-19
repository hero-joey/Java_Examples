package com.hero.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * @description: ContextApp
 *
 *  * MyApplicationContextInitializer接口是在spring容器执行refresh之前的一个回调
 *  * 使用步骤：
 *  * 1.写一个类，实现ApplicationContextInitializer
 *  * 2.注册(
 *    springApplication.addInitializers,
 *    DelegatingApplicationContextInitializer中context.initializer.classes配置方式，可以指定多个,
 *    可以通过spring.factories方式注册(也可以注册listener接口)
 *
 *
 * @date: 2020/10/17
 * @author: bearT
 * @version: 1.0
 */
@SpringBootApplication
public class ContextApp {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ContextApp.class);
        //springApplication.addInitializers(new MyApplicationContextInitializer());
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);

        configurableApplicationContext.close();

    }
}
