package com.hero.designpatten.strategy.evictionv1;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: UserCache
 * @date: 2021/3/12 11:09
 * @author: maccura
 * @version: 1.0
 */
public class UserCache {
    private Map<String, User> cacheData = new HashMap<>();
    private EvictionStrategy evictionStrategy;

    public UserCache(EvictionStrategy evictionStrategy) {
        this.evictionStrategy = evictionStrategy;
    }
}
