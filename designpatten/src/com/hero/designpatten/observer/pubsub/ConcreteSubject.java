package com.hero.designpatten.observer.pubsub;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: ConcreteSubject
 * @date: 2021/3/10 9:06
 * @author: maccura
 * @version: 1.0
 */
public class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
