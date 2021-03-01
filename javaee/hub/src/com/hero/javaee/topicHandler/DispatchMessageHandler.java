package com.hero.javaee.topicHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: dispatchMessageHandler
 * @date: 2021/2/26 10:58
 * @author: maccura
 * @version: 1.0
 */
public class DispatchMessageHandler implements DispatchHandler {

    private static Map<String, String> handlerMap = new HashMap<>();

    static {
        handlerMap.putIfAbsent("image", "com.hero.javaee.topicHandler.ImageTopicHandler");
        handlerMap.putIfAbsent("onlineupgrade", "com.hero.javaee.topicHandler.OnlineUpgradeTopicHandler");
    }

    private  static String getTopicHandler(String topic) {
        return handlerMap.get(topic);
    }

    @Override
    public void dispatchMessage(String topicMessage) {
        String topicHandlerName = getTopicHandler(topicMessage);
        try {
            Class<?> handlerClass = Class.forName(topicHandlerName);
            BaseHandler baseHandler = (BaseHandler) handlerClass.newInstance();

            baseHandler.handleMessage(topicMessage);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
