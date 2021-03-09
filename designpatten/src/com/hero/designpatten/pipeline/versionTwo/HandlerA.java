package com.hero.designpatten.pipeline.versionTwo;

/**
 * @description: HandleA
 * @date: 2021/3/8 14:16
 * @author: maccura
 * @version: 1.0
 */
public class HandlerA extends Handler {
    @Override
    public boolean doHandle() {
        System.out.println("HandlerA process");
        return false;
    }
}
