package com.hero.designpatten.factory;

/**
 * @description: InvalidRuleConfigException
 * @date: 2021/3/3 10:03
 * @author: maccura
 * @version: 1.0
 */
public class InvalidRuleConfigException extends RuntimeException {
    public InvalidRuleConfigException(String message) {
        super(message);
    }
}
