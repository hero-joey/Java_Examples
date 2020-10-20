package com.hero.Bean;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//û����ȷ��ɫ��ʱ��ʹ��
@Component(value = "myUser")
public class User {
	
	//spring�ṩ��ע��
	@Autowired
	private UserService userService;
	
	//JSR 250��ע��
	@Resource
	private Car car;
	
	//JSR 330��ע��
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
