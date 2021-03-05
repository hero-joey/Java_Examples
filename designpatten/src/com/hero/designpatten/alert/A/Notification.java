package com.hero.designpatten.alert.A;

/**
 * @description: Notification
 * @date: 2021/3/5 15:51
 * @author: maccura
 * @version: 1.0
 */
public class Notification {
    public void notify(NotificationEmergencyLevel level, String message) {
        System.out.println(level + " : " + message);
    }
}
