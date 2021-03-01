package com.hero.javaee.topicHandler;

/**
 * @description: OnlineUpgradeTopicHandler
 * @date: 2021/2/26 10:54
 * @author: maccura
 * @version: 1.0
 */
public class OnlineUpgradeTopicHandler implements BaseHandler {
    @Override
    public void handleMessage(String content) {
        System.out.println("OnlineUpgrade handler process message");
    }
}
