package com.hero.Bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationClient {
	public static void main(String[] args) {
		//��Ҫͨ��MyConfigɨ�裬��ȡBean�������޷�����
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext("com.edu.spring");
		System.out.println(configApplicationContext.getBean("&createRunableFactoryBean"));
		System.out.println(configApplicationContext.getBean(Car.class));
		System.out.println(configApplicationContext.getBean(Cat.class));
		System.out.println(configApplicationContext.getBean(Dog.class));
		System.out.println(configApplicationContext.getBean(Animal.class));
	}
}
