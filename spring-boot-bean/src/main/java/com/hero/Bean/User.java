package com.hero.Bean;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//没有明确角色的时候使用
@Component(value = "myUser")
public class User {
	
	//spring提供的注解
	@Autowired
	private UserService userService;
	
	//JSR 250的注释
	@Resource
	private Car car;
	
	//JSR 330的注释
	@Inject
	private Cat cat;
	
	public void show() {
		System.out.println("==show==");
		System.out.println(userService);
	}

	@Override
	public String toString() {
		return "User [userService=" + userService + ", car=" + car + ", cat=" + cat + "]";
	}


	
}
