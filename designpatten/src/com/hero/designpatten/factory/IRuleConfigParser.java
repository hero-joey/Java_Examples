package com.hero.designpatten.factory;

/**
 * @description: IRuleConfigParser
 * @date: 2021/3/3 9:55
 * @author: maccura
 * @version: 1.0
 */
public interface IRuleConfigParser {
    RuleConfig parse(String ruleContent);
}
