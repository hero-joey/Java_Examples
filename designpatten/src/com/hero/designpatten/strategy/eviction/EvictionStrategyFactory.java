package com.hero.designpatten.strategy.eviction;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: StrategyFactory
 * @date: 2021/3/12 10:34
 * @author: maccura
 * @version: 1.0
 */
public class EvictionStrategyFactory {
    private static final Map<String, EvictionStrategy> strategies = new HashMap<>();

    static {
        strategies.put("A", new ConcreteEvictionStrategyA());
        strategies.put("B", new ConcreteEvictionStrategyB());
    }

    public static EvictionStrategy getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty");
        }
        return strategies.get(type);
    }
}
