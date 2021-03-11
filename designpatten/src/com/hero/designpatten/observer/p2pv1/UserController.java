package com.hero.designpatten.observer.p2pv1;

import com.hero.designpatten.observer.p2pv2.RegisterObserver;

/**
 * @description: UserController
 * @date: 2021/3/11 9:35
 * @author: maccura
 * @version: 1.0
 */
public class UserController {
    private UserService userService;
    private PromotionService promotionService;

    public Long register(String username, String password) {
        long userId = userService.register(username, password);

        //异步方式1
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                promotionService.issueNewUserExperienceCash(userId);
            }
        };
        new Thread(runnable).start();
        return userId;
    }
}
