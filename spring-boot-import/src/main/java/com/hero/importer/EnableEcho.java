package com.hero.importer;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @description: EnableEcho
 * @date: 2020/10/14
 * @author: bear
 * @version: 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EchoImportBeanDefinitionRegistrar.class)
public @interface EnableEcho {
    String[] packages();
}
