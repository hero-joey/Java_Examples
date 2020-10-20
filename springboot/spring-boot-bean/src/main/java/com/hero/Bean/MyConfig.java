package com.hero.Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfig {
	//Ĭ�ϻ�ȡ��Bean�Ǹ÷���������
	@Bean(name = "myBean")  
	//Ĭ�ϵ��������ú��ɶ���
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
	
	//����Ҫ�ֶ�����carFactory��ϵͳ���Զ���������config�ļ���ȡ
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
	//װ��ʽ�����ڶ��������ѡ���primary��װ��
	//@Primary
	public UserDao createUserDao()
	{
		return new UserDao();
	}
}
