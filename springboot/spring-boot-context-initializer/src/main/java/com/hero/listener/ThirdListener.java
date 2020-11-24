package com.hero.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;

/**
 * @description: Listener
 * @date: 2020/11/24
 * @author: bear
 * @version: 1.0
 */
@Order(3)
public class ThirdListener implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("Hello,Third listener");
    }
}
