package com.hero.designpatten.pipeline.worldchain;

/**
 * @description: SensitiveWordFilter
 * @date: 2021/3/8 14:37
 * @author: maccura
 * @version: 1.0
 */
public interface SensitiveWordFilter {
    boolean doFilter(Content content);
}
