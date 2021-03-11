package com.hero.designpatten.observer.pubsub;

/**
 * @description: ConcreteObserverOne
 * @date: 2021/3/10 9:10
 * @author: maccura
 * @version: 1.0
 */
public class ConcreteObserverOne implements Observer {
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverOne notified");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
