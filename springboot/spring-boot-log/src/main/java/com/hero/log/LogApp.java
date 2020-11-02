package com.hero.log;

import com.hero.log.dao.UserDao;
import com.hero.log.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @description:
 * 1.#logging.level.root=debug配置文件中，会启用所有的debug日志
 * 2.运行时参数--debug仅打印springbootdebug日志，自定义的debug日志不会打印
 * 3.SpringApplication.run(LogApp.class, "--debug=true");和2一样
 * 4.springboot默认的日志级别是info,logging.level.*=debug可以单独设置某个包或者类
 * 5.日志级别trace debug info warning error fatal off(表示关闭日志输出)
 * 6.可以使用logging.file.name=e:/log/test.log指定日志名和路径,logging.file.path=指定日志路径，默认名字为spring.log,日志大小超过
 * 10M会被分割
 * 7.指定输出格式
 * logging.pattern.console=%d{yyyy-MMM-dd} %-5level [%thread] %logger{15} - %msg%n 指定控制台日志输出patten
 * logging.pattern.file  指定文件日志输出patten
 * 8.springboot默认支持logbacl，在classpath放置logback.xml或者logback-spring.xml
 *
 * @date: 2020/9/9 16:05
 * @author: maccura
 * @version: 1.0
 */
@SpringBootApplication(exclude = WebSocketServletAutoConfiguration.class)
public class LogApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(LogApp.class, args);
        configurableApplicationContext.getBean(UserDao.class).log();
        System.out.println("==========");
        configurableApplicationContext.getBean(UserService.class).log();
    }
}
