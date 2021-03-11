package com.hero.p2p;

import com.google.common.eventbus.Subscribe;

/**
 * @description: NotificationService
 * @date: 2021/3/11 9:43
 * @author: maccura
 * @version: 1.0
 */
public class NotificationService {

    @Subscribe
    public void sendInboxMessage(Long userId, String content) {
        System.out.println(userId + ":" + content);
    }
}
