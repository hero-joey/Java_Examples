package com.hero.multithread.joindemo;

/**
 * Hello world!
 *
 */
public class ThreadApp
{
    public static void main( String[] args )
    {
        HotWaterThread hotWaterThread = new HotWaterThread();
        WashThread washThread = new WashThread();
        hotWaterThread.start();
        washThread.start();

        Thread.currentThread().setName("主线程");
        System.out.println("主线程等待完成");

        try {
            hotWaterThread.join();
            washThread.join();
            System.out.println("主线程已经完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
