package com.hero.multithread.joindemo;

/**
 * @description: HotWaterThread
 * @date: 2021/1/19 13:18
 * @author: maccura
 * @version: 1.0
 */
public class HotWaterThread extends Thread {

    public HotWaterThread() {
        super("hot water thread");
    }

    @Override
    public void run() {
        try {
            System.out.println("烧开水");
            Thread.sleep(2000);
            System.out.println("烧开水完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
