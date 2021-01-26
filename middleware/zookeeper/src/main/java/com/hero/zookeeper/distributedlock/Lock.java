package com.hero.zookeeper.distributedlock;

/**
 * @description: Lock
 * @date: 2021/1/26 10:48
 * @author: maccura
 * @version: 1.0
 */
public interface Lock {
    boolean lock() throws Exception;
    boolean unlock();
}
