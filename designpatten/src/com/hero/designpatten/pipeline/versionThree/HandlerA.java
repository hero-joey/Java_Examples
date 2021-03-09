package com.hero.designpatten.pipeline.versionThree;

/**
 * @description: HandlerA
 * @date: 2021/3/8 14:24
 * @author: maccura
 * @version: 1.0
 */
public class HandlerA implements Ihandler {
    @Override
    public boolean handle() {
        System.out.println("Version Three: Handler A");
        return false;
    }
}
