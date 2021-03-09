package com.hero.designpatten.pipeline.versionTwo;

/**
 * @description: Application
 * @date: 2021/3/8 13:32
 * @author: maccura
 * @version: 1.0
 */
public class Application {
    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();
    }
}
