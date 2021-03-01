package com.hero.javaee.topicHandler;

/**
 * @description: ImageTopicHandler
 * @date: 2021/2/26 10:54
 * @author: maccura
 * @version: 1.0
 */
public class ImageTopicHandler implements BaseHandler  {
    @Override
    public void handleMessage(String content) {
        System.out.println("Image handler process message");
    }
}
