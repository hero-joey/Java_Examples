package com.hero.di;

/**
 * @description: RedisCounter
 * @date: 2021/3/4 10:09
 * @author: maccura
 * @version: 1.0
 */
public class RedisCounter {
    private String ipAddress;
    private Integer port;
    public RedisCounter(String ipAddress, Integer port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }
}
