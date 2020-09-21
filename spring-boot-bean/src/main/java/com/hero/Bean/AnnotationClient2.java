package com.hero.Bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationClient2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(AnnotationScan.class);
		System.out.println(configApplicationContext.getBean("&createRunableFactoryBean"));
		System.out.println(configApplicationContext.getBean(Car.class));
		System.out.println(configApplicationContext.getBean(Cat.class));
		System.out.println(configApplicationContext.getBean(Dog.class));
		System.out.println(configApplicationContext.getBean(Animal.class));
		System.out.println(configApplicationContext.getBean(UserController.class));
		configApplicationContext.close();
	}
}
