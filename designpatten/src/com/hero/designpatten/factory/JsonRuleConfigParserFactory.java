package com.hero.designpatten.factory;

/**
 * @description: JsonRuleConfigParserFactory
 * @date: 2021/3/3 10:47
 * @author: maccura
 * @version: 1.0
 */
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
