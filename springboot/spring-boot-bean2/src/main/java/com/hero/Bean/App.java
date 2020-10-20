package com.hero.Bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		//System.out.println("Hello world");
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext("com.hero.bean");
		System.out.println(configApplicationContext.getBean("user"));
		System.out.println(configApplicationContext.getBean("getUser"));
		//���ڶ�������͵�bean���ᱨ������ʹ�����ֻ�ȡ
		//System.out.println(configApplicationContext.getBean(User.class));

		configApplicationContext.getBean("user", User.class).show();
		configApplicationContext.getBean(Book.class).show();
		configApplicationContext.getBean(Bank.class).show();
		configApplicationContext.getBean(Dog.class).show();
		configApplicationContext.close();
		
	}

}
