package com.hero.designpatten.pipeline.worldchain;

/**
 * @description: SexyWordFilter
 * @date: 2021/3/8 14:38
 * @author: maccura
 * @version: 1.0
 */
public class SexyWordFilter implements SensitiveWordFilter {
    @Override
    public boolean doFilter(Content content) {
        return false;
    }
}
