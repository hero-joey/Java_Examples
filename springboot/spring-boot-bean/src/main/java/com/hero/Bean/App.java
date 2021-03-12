package com.hero.Bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		//System.out.println("Hello world");
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(MyConfig.class,
				User.class, UserDao.class, UserService.class, UserController.class);
		System.out.println(configApplicationContext.getBean(MyBean.class));
		System.out.println(configApplicationContext.getBean("myBean"));
		
		System.out.println(configApplicationContext.getBean(Jeep.class));
		System.out.println(configApplicationContext.getBean("createRunableFactoryBean"));
		System.out.println(configApplicationContext.getBean(RunableFactoryBean.class));
		System.out.println(configApplicationContext.getBean("&createRunableFactoryBean"));
		System.out.println(configApplicationContext.getBean(CarFactory.class));
		System.out.println(configApplicationContext.getBean("&createRunableFactoryBean"));
		System.out.println(configApplicationContext.getBean(Car.class));
		System.out.println(configApplicationContext.getBean(Cat.class));
		System.out.println(configApplicationContext.getBean(Dog.class));
		System.out.println(configApplicationContext.getBean(Animal.class));
		//System.err.println(configApplicationContext.getBean(User.class));
		System.out.println(configApplicationContext.getBeansOfType(User.class));
		System.out.println(configApplicationContext.getBean("myUser"));
		System.out.println(configApplicationContext.getBean("createUser"));
		//System.out.println(configApplicationContext.getBean(UserDao.class));
		System.out.println(configApplicationContext.getBean(UserService.class));
		System.out.println(configApplicationContext.getBean(UserController.class));
		User user = configApplicationContext.getBean("myUser", User.class);
		System.out.println(user.toString());
	

		configApplicationContext.close();
		
	}

}
