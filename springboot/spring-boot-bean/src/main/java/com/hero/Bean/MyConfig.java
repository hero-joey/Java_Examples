package com.hero.Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfig {
	//默认获取的Bean是该方法的名字
	@Bean(name = "myBean")  
	//默认单利，设置后变成多例
	@Scope("prototype")
	public MyBean createMyBean()
	{
		return new MyBean();
	}
	
//	@Bean 
////	public Jeep createJeep()
//	{
//		return new Jeep();
//	}
//	
	@Bean
	public RunableFactoryBean createRunableFactoryBean()
	{
		return new RunableFactoryBean();
	}
	
	@Bean
	public CarFactory createCarFactory()
	{
		return new CarFactory();
	}
	
	//不需要手动创建carFactory，系统会自动创建，从config文件获取
	@Bean
	public Car createJeep(CarFactory factory)
	{
		return factory.create();
	}
	
	@Bean
	public Cat createCat()
	{
		return new Cat();
	}
	
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public Dog createDog()
	{
		return new Dog();
	}
	
	@Bean
	public Animal createAnimal()
	{
		return new Animal();
	}
	
	@Bean User createUser()
	{
		return new User();
	}
	
	@Bean
	//装配式，存在多个，优先选择带primary的装配
	//@Primary
	public UserDao createUserDao()
	{
		return new UserDao();
	}
}
