package com.hero.designpatten.pipeline.versionOne;

/**
 * @description: HandlerB
 * @date: 2021/3/8 13:29
 * @author: maccura
 * @version: 1.0
 */
public class HandlerB extends Handler {
    @Override
    public void handle() {
        boolean handled = false;
        System.out.println("Handler B ");

        if (!handled && successor != null) {
            successor.handle();
        }
    }
}
