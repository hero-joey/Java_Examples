package com.hero.Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DogConfig {
	//优先使用该方式规初始化Bean
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public Dog createDog()
	{
		return new Dog();
	}
}
