package com.hero.designpatten.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: StaticClassIdGenerator
 * @date: 2021/3/2 14:19
 * @author: maccura
 * @version: 1.0
 */
public class StaticClassIdGenerator {
    private AtomicLong id = new AtomicLong(0);

    public static class SingletonHolder {
        private static StaticClassIdGenerator instance = new StaticClassIdGenerator();
    }

    public static StaticClassIdGenerator getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
