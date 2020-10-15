package com.hero.importer;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * ImportBeanDefinitionRegistrar方法的参数有一个BeanDefinitionRegistry,可以动态的注入bean
 * @description: MyImportBeanDefinitionRegistrar
 * @date: 2020/10/14
 * @author: bear
 * @version: 1.0
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(User.class);
        BeanDefinition BeanDefinition = beanDefinitionBuilder.getBeanDefinition();
        registry.registerBeanDefinition("user", BeanDefinition);

        BeanDefinitionBuilder roleBeanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Role.class);
        BeanDefinition roleBeanDefintion = roleBeanDefinitionBuilder.getBeanDefinition();
        registry.registerBeanDefinition("role", roleBeanDefintion);

        /*MyConfiguration也可以注入，类中的bean仍然生效*/
    }
}
