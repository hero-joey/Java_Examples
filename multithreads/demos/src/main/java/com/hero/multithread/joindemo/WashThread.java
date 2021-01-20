package com.hero.multithread.joindemo;

/**
 * @description: WashThread
 * @date: 2021/1/19 13:18
 * @author: maccura
 * @version: 1.0
 */
public class WashThread extends Thread {
    public WashThread() {
        super("wash thread");
    }

    @Override
    public void run() {
        try {
            System.out.println("清洗茶具");
            Thread.sleep(3000);
            System.out.println("清洗茶具完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
