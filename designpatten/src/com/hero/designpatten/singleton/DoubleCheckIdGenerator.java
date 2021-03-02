package com.hero.designpatten.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: DoubleCheckIdGenerator
 * @date: 2021/3/2 14:12
 * @author: maccura
 * @version: 1.0
 */
public class DoubleCheckIdGenerator {
    private AtomicLong id = new AtomicLong(0);
    private static DoubleCheckIdGenerator INSTANCE;

    private DoubleCheckIdGenerator() {
    }

    public static DoubleCheckIdGenerator getInstance() {
        if (INSTANCE == null) {
            //此处为类级别的锁
            synchronized (DoubleCheckIdGenerator.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckIdGenerator();
                }
            }
        }
        return INSTANCE;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
