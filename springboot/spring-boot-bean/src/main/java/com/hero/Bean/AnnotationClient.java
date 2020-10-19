package com.hero.Bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationClient {
	public static void main(String[] args) {
		//需要通过MyConfig扫描，获取Bean，否则无法创建
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext("com.edu.spring");
		System.out.println(configApplicationContext.getBean("&createRunableFactoryBean"));
		System.out.println(configApplicationContext.getBean(Car.class));
		System.out.println(configApplicationContext.getBean(Cat.class));
		System.out.println(configApplicationContext.getBean(Dog.class));
		System.out.println(configApplicationContext.getBean(Animal.class));
	}
}
