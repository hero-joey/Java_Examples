package com.hero.Bean;

import org.springframework.beans.factory.FactoryBean;

public class RunableFactoryBean implements FactoryBean<Jeep> {

	@Override
	public Jeep getObject() throws Exception {
			return new Jeep();
	}

	@Override
	public Class<?> getObjectType() {
		return Jeep.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
