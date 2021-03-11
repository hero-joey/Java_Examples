package com.hero.designpatten.observer.eventbus;

import java.util.concurrent.Executor;

/**
 * @description: AsyncEventBus
 * @date: 2021/3/11 13:35
 * @author: maccura
 * @version: 1.0
 */
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
