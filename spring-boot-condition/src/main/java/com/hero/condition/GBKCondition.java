package com.hero.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @description: GBKCondition
 * @date: 2020/10/13
 * @author: bear
 * @version: 1.0
 */
public class GBKCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String fileEncoding = context.getEnvironment().getProperty("file.encoding");
        if (fileEncoding != null) {
            return "gbk".equals(fileEncoding.toLowerCase());
        }
        return false;
    }
}
