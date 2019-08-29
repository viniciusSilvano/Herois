package com.stefanini.heroi.bo.partida;

import java.util.Random;

import org.springframework.beans.factory.FactoryBean;

public class DueloFactory implements FactoryBean<IDuelo> {
	private static Random random = new Random();
	private static DueloFactory instance = new DueloFactory();
	
	public static DueloFactory getInstance() {
		return instance;
	}
	@Override
	public IDuelo getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Duelo(random);
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return IDuelo.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
