package com.hero.di;

/**
 * @description: RateLimiter
 * @date: 2021/3/4 10:09
 * @author: maccura
 * @version: 1.0
 */
public class RateLimiter {
    private RedisCounter redisCounter;

    public RateLimiter(RedisCounter redisCounter) {
        this.redisCounter = redisCounter;
    }

    public void test() {
        System.out.println("Hello world");
    }
}
