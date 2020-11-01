package com.hero.aop;

import com.hero.aop.dao.UserDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description:
 *
 * spring.aop.auto=false 或者true可以配置是否启用，默认是true
 * 默认是使用基于jdk的动态代理来实现aop
 * spring.aop.auto=false或者不配置，表示使用jdk的动态代理
 * =true表示使用cglib
 * 如果配置了false，而类没有接口，依然使用cglib
 * EnableAspectJAutoProxy用于设置代理
 * @param:
 * @return:
 * @auther: bear
 * @date: 2020/11/1
 */
//@EnableAspectJAutoProxy
@SpringBootApplication
public class AopApp {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AopApp.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
        //配置类不同, JdkDynamicAutoProxyConfiguration   CglibAutoProxyConfiguration
        System.out.println(configurableApplicationContext.getBean(UserDao.class).getClass());
        configurableApplicationContext.getBean(UserDao.class).addUser("admin", "123456");
        configurableApplicationContext.close();

    }
}
