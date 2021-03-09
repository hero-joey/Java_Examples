package com.hero.designpatten.pipeline.worldchain;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: SensitiveWordFilterChain
 * @date: 2021/3/8 14:39
 * @author: maccura
 * @version: 1.0
 */
public class SensitiveWordFilterChain {
    private List<SensitiveWordFilter> filters = new ArrayList<>();

    public void addFilter(SensitiveWordFilter filter) {
        this.filters.add(filter);
    }

    public boolean filter(Content content) {
        for (SensitiveWordFilter filter : filters) {
            if (!filter.doFilter(content)) {
                return false;
            }
        }
        return true;
    }
}
