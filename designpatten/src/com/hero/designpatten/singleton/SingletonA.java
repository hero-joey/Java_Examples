package com.hero.designpatten.singleton;

/**
 * @description: Singleton
 * @date: 2021/3/2 15:38
 * @author: maccura
 * @version: 1.0
 */
public class SingletonA {
    private static SingletonA instance = null;
    private final int paramA;
    private final int paramB;

    private SingletonA(int paramA, int paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public static SingletonA getInstance() {
        if (instance == null) {
            throw new RuntimeException("run init() first");
        }
        return instance;
    }

    public synchronized static void init(int paramA, int paramB) {
        if (instance != null) {
            throw new RuntimeException("Singleton has been created");
        }

        instance = new SingletonA(paramA, paramB);
    }


    public static void main(String[] args) {

        SingletonA.init(10, 50);
        SingletonA singletonA = SingletonA.getInstance();

    }
}
