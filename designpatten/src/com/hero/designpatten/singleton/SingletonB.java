package com.hero.designpatten.singleton;

/**
 * @description: SingletonB
 * @date: 2021/3/2 15:49
 * @author: maccura
 * @version: 1.0
 */
public class SingletonB {
    private static SingletonB instance = null;
    private int paramA;
    private int paramB;

    private SingletonB(int paramA, int paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public static SingletonB getInstance(int paramA, int paramB) {
        if (instance == null) {
            instance = new SingletonB(paramA, paramB);
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonB singletonB1 = SingletonB.getInstance(10, 50);
        SingletonB singletonB2 = SingletonB.getInstance(20, 50);

    }
}
