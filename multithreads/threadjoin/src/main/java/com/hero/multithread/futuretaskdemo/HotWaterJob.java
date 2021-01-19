package com.hero.multithread.futuretaskdemo;

import java.util.concurrent.Callable;

/**
 * @description: HotWaterJob
 * @date: 2021/1/19 13:46
 * @author: maccura
 * @version: 1.0
 */
public class HotWaterJob implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        try {
            System.out.println("烧开水");
            Thread.sleep(2000);
            System.out.println("烧开水完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
