package com.hero.designpatten.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: IdGenerator
 * @date: 2021/3/2 13:26
 * @author: maccura
 * @version: 1.0
 */
public class EagerIdGenerator {
    private AtomicLong id = new AtomicLong(0);
    private static final EagerIdGenerator INSTANCE = new EagerIdGenerator();
    private EagerIdGenerator() {
    }

    public static EagerIdGenerator getInstance() {
        return INSTANCE;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println(EagerIdGenerator.getInstance().getId());
        System.out.println(EagerIdGenerator.getInstance().getId());
        System.out.println(EagerIdGenerator.getInstance().getId());
    }
}
