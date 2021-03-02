package com.hero.designpatten.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: EnumIdGenerator
 * @date: 2021/3/2 14:40
 * @author: maccura
 * @version: 1.0
 */
public enum EnumIdGenerator {
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);
    public Long getId() {
        return id.incrementAndGet();
    }
}
