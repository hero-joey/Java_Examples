package com.hero.designpatten.observer.pubsub;

/**
 * @description: ConcreteObserverTwo
 * @date: 2021/3/10 9:10
 * @author: maccura
 * @version: 1.0
 */
public class ConcreteObserverTwo implements Observer {
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverTwo notified");
    }
}
