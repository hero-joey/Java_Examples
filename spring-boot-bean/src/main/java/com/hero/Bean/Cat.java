package com.hero.Bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cat implements InitializingBean, DisposableBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean");
		
	}

}