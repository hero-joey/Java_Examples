package com.hero.event;

import org.springframework.context.ApplicationEvent;

/**
 * @description: MyApplicationEvent
 * @date: 2020/10/17
 * @author: bear
 * @version: 1.0
 */
public class MyApplicationEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyApplicationEvent(Object source) {
        super(source);
    }
}
