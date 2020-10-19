package com.hero.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 两种获取配置的方式
 * 配置文件默认的名字为application.properties，默认的位置在classpath根目录、classpath:/config目录、file:/、file:/config目录下
 * 默认的配置文件名字可以使用--spring.config.name指定,只需要指定文件名字,扩展名可以省略
 * 默认的配置文件路径可以使用--spring.config.location指定， 配置文件需要指定全路径，包括目录和文件名字,还可以指定多个，多个用,隔开，
 * 例如--spring.config.location=classpath:/conf/app.properties, file:/F:/tomcat.properties
 * 文件的指定方式有两种，classpath和file
 * @description: UserConfig
 * @date: 2020/10/11
 * @author: bear
 * @version: 1.0
 */
@Component
public class UserConfig {

    @Autowired
    private Environment environment;
    @Value("${local.port}")
    private String localPort;

    @Value("${local.port}")
    private Integer localPort2;

    //value必须要有配置项，但可以为空，如果没有配置项，则可以给默认值
    @Value("${tomcat.port:9090}")
    private Integer tomcatPort;

    public void show() {
        System.out.println("localHost: " + environment.getProperty("local.ip"));
        System.out.println("localPort: " + localPort);
        //可以将配置文件参数，转换成T类型
        System.out.println("localPort: " + environment.getProperty("local.port", Integer.class));
        System.out.println("localPort2: " + localPort2);
        System.out.println("appName: " + environment.getProperty("app.name"));
        System.out.println("tomcatPort: " + tomcatPort);
    }
}
