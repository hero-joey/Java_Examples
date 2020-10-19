package com.hero.source;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
/**
 * @description:运行流程
 * 1.判断是不是WEB环境
 * 2.加载所有classpath META-INF/spring.factories ApplicationContextInitializer
 * 3.加载 ApplicationListener
 * 4.搜索main方法所在类
 * 5.开始执行run方法
 * 6.设置系统变量java.awt.headless
 * 7.加载所有SpringApplicationRunListener
 * 8.执行SpringApplicationRunListener start所有的方法
 * 9.实例化ApplicationArguments
 * 10.创建enviroment
 * 11.配置enviroment
 * 12.执行SpringApplicationRunListener enviroment prepared所有的方法
 * 13.如果不是web环境，但是是web environment，则把这个web enviroment转换成标准的enviroment
 * 14.打印banner
 * 15.初始化applicationContext，ConfigurableApplicationContext
 * 16.如果beanNameGenerator，则注册
 * 17.回调所有的ApplicationContextInitializer
 * 18.执行SpringApplicationRunListener 的context prepared所有的方法
 * 19.依次往容器注入springApplicationArguments springBootBanner对象
 * 20.加载所有的源到context里面去
 * 21.执行SpringApplicationRunListener contetxtloaded
 * 22.执行context的refresh方法，并且调用registerShutdownHook勾子
 * 23.回调，获取容器中所有的ApplicationRunner，CommandLineRunner依次调用run方法
 * 24.执行SpringApplicationRunListener 的context finish所有的方法
 *
 *
 * @param:p
 * @return:
 * @auther: bear
 * @date: 2020/10/20
 */
@SpringBootApplication
public class SourceApp {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SourceApp.class);
        //springApplication.addInitializers(new MyApplicationContextInitializer());
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
        ApplicationArguments applicationArguments = configurableApplicationContext.getBean(ApplicationArguments.class);
        String name = applicationArguments.getOptionNames().toString();
        System.out.println(name);
        System.out.println(applicationArguments.getOptionValues("name"));
        configurableApplicationContext.close();

    }
}
