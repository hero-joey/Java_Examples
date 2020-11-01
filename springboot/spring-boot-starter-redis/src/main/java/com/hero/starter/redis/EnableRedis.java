package com.hero.starter.redis;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @description: EnableRedis
 * @date: 2020/11/1
 * @author: bear
 * @version: 1.0
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
@Import(RedisAutoConfiguration.class)
public @interface EnableRedis {
}
