package com.hero.designpatten.pipeline.versionTwo;

/**
 * @description: HandlerB
 * @date: 2021/3/8 14:17
 * @author: maccura
 * @version: 1.0
 */
public class HandlerB extends Handler {
    @Override
    public boolean doHandle() {
        System.out.println("HandlerB");
        return false;
    }
}
