package com.hero.p2p;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @description: UserController
 * @date: 2021/3/11 9:35
 * @author: maccura
 * @version: 1.0
 */
public class UserController {
    private UserService userService;
    private EventBus eventBus;
    private static final int DEFAULT_EVENT_THREAD_POOL_SIZE = 5;

    public UserController(UserService userService) {
        //this.eventBus = new EventBus();  同步阻塞模式
        this.userService = userService;
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENT_THREAD_POOL_SIZE));
    }

    //设置观察者
    public void setObservers(List<Object> observers) {
        for (Object object : observers) {
            eventBus.register(object);
        }
    }

    public Long register(String username, String password) {
        long userId = userService.register(username, password);
        eventBus.post(userId);
        return userId;
    }
}
