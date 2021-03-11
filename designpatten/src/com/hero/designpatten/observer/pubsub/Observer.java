package com.hero.designpatten.observer.pubsub;

/**
 * @description: Observer
 * @date: 2021/3/10 9:05
 * @author: maccura
 * @version: 1.0
 */
public interface Observer {
    void update(Message message);
}
