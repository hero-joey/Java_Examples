package com.hero.zookeeper.distributedlock;

/**
 * @description: ZLock
 * @date: 2021/1/26 11:01
 * @author: maccura
 * @version: 1.0
 */
public class ZkLock implements Lock {

    final private String rootPath = "/lock";
    final private String lockPath = rootPath + "/";
    final private Integer waitTime = 1000;

    @Override
    public boolean lock() throws Exception {
        return false;
    }

    @Override
    public boolean unlock() {
        return false;
    }
}
