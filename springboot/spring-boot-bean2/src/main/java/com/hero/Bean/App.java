package com.hero.Bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		//System.out.println("Hello world");
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext("com.hero.bean");
		System.out.println(configApplicationContext.getBean("user"));
		System.out.println(configApplicationContext.getBean("getUser"));
		//存在多个该类型的bean，会报错，可以使用名字获取
		//System.out.println(configApplicationContext.getBean(User.class));

		configApplicationContext.getBean("user", User.class).show();
		configApplicationContext.getBean(Book.class).show();
		configApplicationContext.getBean(Bank.class).show();
		configApplicationContext.getBean(Dog.class).show();
		configApplicationContext.close();
		
	}

}
