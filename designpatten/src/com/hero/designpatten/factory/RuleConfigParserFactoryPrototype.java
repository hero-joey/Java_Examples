package com.hero.designpatten.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: RuleConfigParserFactory
 * @date: 2021/3/3 10:10
 * @author: maccura
 * @version: 1.0
 */
public class RuleConfigParserFactoryPrototype {
    static Map<String, IRuleConfigParser> cachedRuleConfigParserMap = new HashMap<>();

    static {
        cachedRuleConfigParserMap.put("json", new JsonRuleConfigParser());
        cachedRuleConfigParserMap.put("xml", new XmlRuleConfigParser());
        cachedRuleConfigParserMap.put("yaml", new YamlRuleConfigParser());
        cachedRuleConfigParserMap.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            return null;
        }

        return cachedRuleConfigParserMap.get(configFormat);
    }

    public static void main(String[] args) {
        IRuleConfigParser ruleConfigParser = RuleConfigParserFactoryPrototype.createParser("json");
        System.out.println(ruleConfigParser.getClass().getSimpleName());

        IRuleConfigParser ruleConfigParser2 = RuleConfigParserFactoryPrototype.createParser("doc");
        System.out.println(ruleConfigParser2.getClass().getSimpleName());
    }
}
