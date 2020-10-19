package com.hero.event;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @description: MyEventHandle
 * @date: 2020/10/17
 * @author: bear
 * @version: 1.0
 */
@Component
public class MyEventHandle {

    /**
     * @description:
     * 参数任意
     * 所有该参数事件，或者事件子类都可以接受到
     * @param: [event]
     * @return: void
     * @auther: bear
     * @date: 2020/10/17
     */
    @EventListener
    public void onApplicationEvent(MyApplicationEvent event) {
        System.out.println("接受到事件2: " + event.getClass());
    }

    @EventListener
    public void ContextCloseApplicationEvent(ContextClosedEvent contextClosedEvent) {
        System.out.println("contextClosedEvent");
    }
}
