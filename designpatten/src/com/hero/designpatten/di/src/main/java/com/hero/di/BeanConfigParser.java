package com.hero.di;

import java.io.InputStream;
import java.util.List;

/**
 * @description: BeanConfigParser
 * @date: 2021/3/4 13:23
 * @author: maccura
 * @version: 1.0
 */
public interface BeanConfigParser {
    List<BeanDefinition> parse(InputStream inputStream);
    List<BeanDefinition> parse(String configContent);
}
