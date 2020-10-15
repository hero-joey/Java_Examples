package com.hero.importer;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @description: EnableLog
 * @date: 2020/10/14
 * @author: bear
 * @version: 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(MyImportSelector.class)
@Import(MyImportBeanDefinitionRegistrar.class)
public @interface EnableLog {
    String name() default "";
}
