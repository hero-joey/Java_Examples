package com.hero.importer;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * ImportSelector方法的返回值必须是class的全称,该class会被spring容器托管起来
 * @description: MyImportSelector
 * @date: 2020/10/14
 * @author: bear
 * @version: 1.0
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println(importingClassMetadata.getAllAnnotationAttributes(EnableLog.class.getName()));
        /*
        * 这里可以拿到详细的注解信息，然后根据信息去动态的返回需要被spring容器管理的bean
        * */
        return new String[] {"com.hero.importer.User", Role.class.getName(), MyConfiguration.class.getName()};
    }
}
