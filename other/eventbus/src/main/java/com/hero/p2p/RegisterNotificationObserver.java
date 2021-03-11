package com.hero.p2p;

import com.google.common.eventbus.Subscribe;

/**
 * @description: RegisterNotificationObserver
 * @date: 2021/3/11 9:42
 * @author: maccura
 * @version: 1.0
 */
public class RegisterNotificationObserver {
    private NotificationService notificationService;

    public RegisterNotificationObserver(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Subscribe
    public void handleRegisterSuccess(Long userId) {
        notificationService.sendInboxMessage(userId, "Hello");
    }
}
