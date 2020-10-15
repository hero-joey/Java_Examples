package com.hero.importer;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @description: EchoImportBeanDefinitionRegistrar
 * @date: 2020/10/14
 * @author: bear
 * @version: 1.0
 */
public class EchoImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println(importingClassMetadata.getClassName());
        Map<String, Object> attr = importingClassMetadata.getAnnotationAttributes(EnableEcho.class.getName());
        String[] packages = (String[])attr.get("packages");
        List<String> packs = Arrays.asList(packages);
        System.out.println("packages: " + packs);

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(EchoBeanPostProcessor.class);
        beanDefinitionBuilder.addPropertyValue("packages", packs);
        BeanDefinition BeanDefinition = beanDefinitionBuilder.getBeanDefinition();
        registry.registerBeanDefinition("echo", BeanDefinition);
    }
}
