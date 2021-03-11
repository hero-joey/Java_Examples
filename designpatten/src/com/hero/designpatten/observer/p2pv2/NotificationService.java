package com.hero.designpatten.observer.p2pv2;

/**
 * @description: NotificationService
 * @date: 2021/3/11 9:43
 * @author: maccura
 * @version: 1.0
 */
public class NotificationService {
    public void sendInboxMessage(Long userId, String content) {
        System.out.println(userId + ":" + content);
    }
}
