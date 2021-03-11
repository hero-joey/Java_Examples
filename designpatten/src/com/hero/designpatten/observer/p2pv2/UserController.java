package com.hero.designpatten.observer.p2pv2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @description: UserController
 * @date: 2021/3/11 9:35
 * @author: maccura
 * @version: 1.0
 */
public class UserController {
    private UserService userService;
    private PromotionService promotionService;
    private List<RegisterObserver> observers = new ArrayList<>();
    private Executor executor;

    public UserController(Executor executor) {
        this.executor = executor;
    }

    //设置观察者
    public void setObservers(List<RegisterObserver> observers) {
        this.observers.addAll(observers);
    }

    public Long register(String username, String password) {
        long userId = userService.register(username, password);

        //异步方式2
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //执行注册事件
                for (RegisterObserver registerObserver : observers) {
                    registerObserver.handleRegisterSuccess(userId);
                }
            }
        };
        executor.execute(runnable);

        return userId;
    }
}
