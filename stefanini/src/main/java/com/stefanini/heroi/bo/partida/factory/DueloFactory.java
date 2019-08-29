package com.stefanini.heroi.bo.partida.factory;

import java.util.Random;

import org.springframework.beans.factory.FactoryBean;

import com.stefanini.heroi.bo.partida.Duelo;

public class DueloFactory implements FactoryBean<IDuelo> {
	private static Random random = new Random();
	private static DueloFactory instance;
	
	private DueloFactory() {
		
	}
	public static DueloFactory getInstance() {
		if(instance == null) {
			instance = new DueloFactory();
			return instance;
		}else {
			return instance;
		}
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
