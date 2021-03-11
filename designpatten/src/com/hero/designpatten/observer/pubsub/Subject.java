package com.hero.designpatten.observer.pubsub;

/**
 * @description: Subject
 * @date: 2021/3/10 9:04
 * @author: maccura
 * @version: 1.0
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Message message);
}
