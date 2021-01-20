package com.hero.multithread.futuretaskdemo;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description: FutureTaskDemo
 * @date: 2021/1/19 13:48
 * @author: maccura
 * @version: 1.0
 */
public class FutureTaskDemo {

    public static void drinkTea(Boolean washOk, Boolean waterOk) {
        if (washOk && waterOk) {
            System.out.println("成功喝茶");
        }

        if (!washOk) {
            System.out.println("清洗茶具失败，没法喝茶");
        }

        if (!waterOk) {
            System.out.println("烧水失败，没法喝茶");
        }
    }

    public static void main(String[] args) {
        HotWaterJob hotWaterJob = new HotWaterJob();
        FutureTask<Boolean> hotWaterTask = new FutureTask<>(hotWaterJob);
        Thread hotWaterThread = new Thread(hotWaterTask);
        hotWaterThread.start();

        WashJob washJob = new WashJob();
        FutureTask<Boolean> washTask = new FutureTask<>(washJob);
        Thread washThread = new Thread(washTask);
        washThread.start();

        try {
            Boolean waterOk = hotWaterTask.get();
            Boolean washOk = washTask.get();

            drinkTea(washOk, waterOk);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
