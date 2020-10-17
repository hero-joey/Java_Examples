package com.hero.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 1.自定义事件,继承ApplicationEvent
 * 2.自定义事件监听，继承ApplicationListener
 * 3.配置监听器，需要把监听器加载到spring容器中,
 * 使用component纳入到容器里面,
 * context.listener.classes配置监听类（DelegatingApplicationListener代码实现）
 * 使用EventListener，参照EventListenerMethodProcessor和EventListenerFactory)
 * 3.发布事件  configurableApplicationContext.publishEvent
 *
 * @description: EventApp
 * @date: 2020/10/17
 * @author: bearT
 * @version: 1.0
 */
@SpringBootApplication
public class EventApp {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(EventApp.class);
        //springApplication.addListeners(new MyApplicationListener());

        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
        configurableApplicationContext.publishEvent(new MyApplicationEvent(new Object()));
        configurableApplicationContext.close();

    }
}
