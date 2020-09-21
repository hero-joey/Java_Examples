package com.hero.Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	//ͨ������ָ��ʹ���ĸ�userDao
	@Qualifier("createUserDao")
	private UserDao userDao;
	
	public void show() {
		System.out.println("==show==");
		System.out.println(userDao);
	}

	@Override
	public String toString() {
		return "UserService [userDao=" + userDao + "]";
	}
	
	
}
