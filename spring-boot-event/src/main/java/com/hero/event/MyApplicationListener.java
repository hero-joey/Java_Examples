package com.hero.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @description: MyApplicationListener
 * @date: 2020/10/17
 * @author: bear
 * @version: 1.0
 */
//@Component
public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {

    @Override
    public void onApplicationEvent(MyApplicationEvent event) {
        System.out.println("接受到事件: " + event.getClass());
    }
}
