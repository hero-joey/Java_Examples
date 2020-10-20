package com.hero.Bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		//System.out.println("Hello world");
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext("com.hero.bean");
		//System.out.println(configApplicationContext.getBean(Person.class));
		configApplicationContext.getBeansOfType(Person.class).values().forEach(System.out::println);

		//�˴�Ҳ����ע��bean,�ο�MyBeanDefinitionRegistryPostProcessor
		//configApplicationContext.registerBeanDefinition();
		configApplicationContext.close();
		
	}

}
