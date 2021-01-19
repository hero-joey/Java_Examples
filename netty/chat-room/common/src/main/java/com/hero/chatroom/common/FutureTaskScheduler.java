package com.hero.chatroom.common;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: FutureTaskScheduler
 * @date: 2021/1/18
 * @author: bear
 * @version: 1.0
 */
public class FutureTaskScheduler extends Thread {

    private static final FutureTaskScheduler futureTaskScheduler = new FutureTaskScheduler();

    private FutureTaskScheduler() {
        this.start();
    }

    class ExecuteRunnable implements Runnable {
        ExecuteTask executeTask;

        ExecuteRunnable(ExecuteTask executeTask) {
            this.executeTask = executeTask;
        }

        public void run() {
            executeTask.execute();
        }
    }

    private final ConcurrentLinkedDeque<ExecuteTask> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    private void executeTask(ExecuteTask task) {
        executorService.execute(new ExecuteRunnable(task));
    }

    private void handleTask() {
        while (concurrentLinkedDeque.peek() != null) {
            ExecuteTask executeTask = concurrentLinkedDeque.poll();
            executeTask(executeTask);
        }
    }

    public static void addTask(ExecuteTask executeTask) {
        futureTaskScheduler.concurrentLinkedDeque.add(executeTask);
    }

    private void threadSleep(Long millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Long threadSleepMillis = 100L;

        while (true) {
            handleTask();
            threadSleep(threadSleepMillis);
        }
    }
}
