package com.hero.commandline;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @description: ConmmadlineApp
 * CommandLineRunner/ApplicationRunner是在spring容器启动成功后，最后一步的回调，类似于开机自启动
 * 使用步骤：
 * 1.写一个类，实现该接口
 * 2.该类纳入spring容器，component
 * 注意:可以通过@Order(1)注解或者Ordered接口控制顺序
 * CommandLineRunner、ApplicationRunner区别仅在于参数不同，一个是原始参数，一个对参数做了封装,可以解析name-value
 * @date: 2020/10/17
 * @author: bearT
 * @version: 1.0
 */
@SpringBootApplication
public class ConmmadlineApp {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ConmmadlineApp.class);
        //springApplication.addInitializers(new MyApplicationContextInitializer());
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
        ApplicationArguments applicationArguments = configurableApplicationContext.getBean(ApplicationArguments.class);
        String name = applicationArguments.getOptionNames().toString();
        System.out.println(name);
        System.out.println(applicationArguments.getOptionValues("name"));
        configurableApplicationContext.close();

    }
}
