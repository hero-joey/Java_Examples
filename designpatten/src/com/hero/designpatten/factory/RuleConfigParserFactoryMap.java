package com.hero.designpatten.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: RuleConfigParserFactoryMap
 * @date: 2021/3/3 10:57
 * @author: maccura
 * @version: 1.0
 */
public class RuleConfigParserFactoryMap {
    private static final Map<String, IRuleConfigParserFactory> CACHED_FACTORIES = new HashMap<>();
    static {
        CACHED_FACTORIES.put("json", new JsonRuleConfigParserFactory());
        CACHED_FACTORIES.put("xml", new XmlRuleConfigParserFactory());
        CACHED_FACTORIES.put("yaml", new YamlRuleConfigParserFactory());
        CACHED_FACTORIES.put("properties", new PropertiesRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getParserFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        return CACHED_FACTORIES.get(type.toLowerCase());
    }

}
