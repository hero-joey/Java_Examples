package com.hero.designpatten.strategy.sort.v3;

import com.hero.designpatten.strategy.sort.v2.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: SortAlgFactory
 * @date: 2021/3/12 13:15
 * @author: maccura
 * @version: 1.0
 */
public class SortAlgFactory {
    private static final Map<String, ISortAlg> sortAlgs = new HashMap<>();

    static {
        sortAlgs.put("QuickSort", new QuickSort());
        sortAlgs.put("ExternalSort", new ExternalSort());
        sortAlgs.put("ConcurrentExternalSort", new ConcurrentExternalSort());
        sortAlgs.put("MapReduceSort", new MapReduceSort());
    }

    public static ISortAlg getSortAlg(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty");
        }
        return sortAlgs.get(type);
    }
}
