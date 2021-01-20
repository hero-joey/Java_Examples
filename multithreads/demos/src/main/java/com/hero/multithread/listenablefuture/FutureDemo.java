package com.hero.multithread.listenablefuture;

import com.google.common.util.concurrent.*;
import com.hero.multithread.futuretaskdemo.HotWaterJob;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.sql.SQLOutput;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: MainJob
 * @date: 2021/1/19 14:49
 * @author: maccura
 * @version: 1.0
 */
public class FutureDemo {

    static class HotWaterJob implements Callable<Boolean> {
        @Override
        public Boolean call() throws Exception {
            try {
                System.out.println("烧开水");
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }

            return true;
        }
    }

    static class WashJob implements Callable<Boolean> {
        @Override
        public Boolean call() throws Exception {
            try {
                System.out.println("清洗茶具");
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
    }

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

    static class MainJob implements Runnable {
        Boolean waterOk = false;
        Boolean washOk = false;

        @Override
        public void run() {
            System.out.println("读书中………………");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            drinkTea(washOk, waterOk);
        }
    }

    public static void main(String[] args) {

        MainJob mainJob = new MainJob();
        Thread mainThread = new Thread(mainJob);
        mainThread.setName("Main Thread");
        mainThread.start();

        Callable<Boolean> hotWaterJob = new HotWaterJob();
        Callable<Boolean> washJob = new WashJob();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);

        ListenableFuture<Boolean> hotWaterFuture = listeningExecutorService.submit(hotWaterJob);
        Futures.addCallback(hotWaterFuture, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(@Nullable Boolean result) {
                if (result) {
                    mainJob.waterOk = true;
                    System.out.println("烧水成功");
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("烧水成功打印");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("烧水失败");
            }
        }, executorService);

        ListenableFuture<Boolean> washFuture = listeningExecutorService.submit(washJob);
        Futures.addCallback(washFuture, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(@Nullable Boolean result) {
                if (result) {
                    mainJob.washOk = true;
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("清洗完成");
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("清洗完成打印");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println(Thread.currentThread().getName());
                System.out.println("清洗失败");
            }
        }, executorService);


    }
}
