package com.hero.designpatten.observer.p2pv2;

/**
 * @description: RegisterNotificationObserver
 * @date: 2021/3/11 9:42
 * @author: maccura
 * @version: 1.0
 */
public class RegisterNotificationObserver implements RegisterObserver {
    private NotificationService notificationService;

    @Override
    public void handleRegisterSuccess(Long userId) {
        notificationService.sendInboxMessage(userId, "Hello");
    }
}
