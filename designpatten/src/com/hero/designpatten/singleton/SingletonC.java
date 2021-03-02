package com.hero.designpatten.singleton;

/**
 * @description: SingletonC  推荐该方式创建单例模式
 * @date: 2021/3/2 15:49
 * @author: maccura
 * @version: 1.0
 */
public class SingletonC {
    private static SingletonC instance = null;
    private int paramA;
    private int paramB;

    private SingletonC() {
        this.paramA = SingletonConfig.PARAM_A;
        this.paramB = SingletonConfig.PARAM_B;
    }

    public synchronized static SingletonC getInstance() {
        if (instance == null) {
            instance = new SingletonC();
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonC singletonB1 = SingletonC.getInstance();
    }
}
