package com.hero.designpatten.observer.pubsub;

/**
 * @description: Demo
 * @date: 2021/3/10 9:12
 * @author: maccura
 * @version: 1.0
 */
public class Demo {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.registerObserver(new ConcreteObserverOne());
        concreteSubject.registerObserver(new ConcreteObserverTwo());
        concreteSubject.notifyObservers(new Message());
    }
}
