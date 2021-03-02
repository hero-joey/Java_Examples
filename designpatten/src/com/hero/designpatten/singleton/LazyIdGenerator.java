package com.hero.designpatten.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: IdGenerator
 * @date: 2021/3/2 13:26
 * @author: maccura
 * @version: 1.0
 */
public class LazyIdGenerator {
    private AtomicLong id = new AtomicLong(0);
    private static LazyIdGenerator INSTANCE;

    private LazyIdGenerator() {
    }

    public static synchronized LazyIdGenerator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazyIdGenerator();
        }
        return INSTANCE;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println(LazyIdGenerator.getInstance().getId());
        System.out.println(LazyIdGenerator.getInstance().getId());
        System.out.println(LazyIdGenerator.getInstance().getId());
    }
}
