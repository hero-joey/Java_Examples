package com.hero.multithread.futuretaskdemo;

import java.util.concurrent.Callable;

/**
 * @description: WashJob
 * @date: 2021/1/19 13:46
 * @author: maccura
 * @version: 1.0
 */
public class WashJob implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        try {
            System.out.println("清洗茶具");
            Thread.sleep(3000);
            System.out.println("清洗茶具完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
