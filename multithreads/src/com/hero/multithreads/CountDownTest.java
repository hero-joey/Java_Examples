package com.hero.multithreads;

import java.util.concurrent.*;

/**
 * @description: CountDownTest
 * @date: 2020/12/22 18:45
 * @author: maccura
 * @version: 1.0
 */
public class CountDownTest {
    public static void main(String[] args) {
        int count = 200;
        final CountDownLatch countDownLatch = new CountDownLatch(200);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for ( int i = 0; i < count; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(countDownLatch.getCount());
                    Thread.sleep(1000);
                    countDownLatch.countDown();
                }
            });
        }


        try {
            countDownLatch.await(10, TimeUnit.SECONDS);
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
