package com.hero.designpatten.pipeline.versionOne;

/**
 * @description: HandlerB
 * @date: 2021/3/8 13:29
 * @author: maccura
 * @version: 1.0
 */
public class HandlerC extends Handler {
    @Override
    public void handle() {
        boolean handled = false;
        System.out.println("Handler C ");

        if (!handled && successor != null) {
            successor.handle();
        }
    }
}
