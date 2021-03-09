package com.hero.designpatten.pipeline.versionOne;

/**
 * @description: HandleA
 * @date: 2021/3/8 13:28
 * @author: maccura
 * @version: 1.0
 */
public class HandlerA extends Handler {
    @Override
    public void handle() {
        boolean handled = false;
        System.out.println("Handler A ");
        if (!handled && successor != null) {
            successor.handle();
        }
    }
}
