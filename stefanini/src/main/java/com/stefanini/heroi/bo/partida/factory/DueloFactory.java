package com.stefanini.heroi.bo.partida.factory;

import java.util.Random;

import org.springframework.beans.factory.FactoryBean;

import com.stefanini.heroi.bo.partida.Duelo;

public class DueloFactory implements FactoryBean<IDuelo> {
	private static Random random = new Random();
	private static DueloFactory instance;
	
	public DueloFactory() {
		
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
		return new Duelo(random);
	}

	@Override
	public Class<?> getObjectType() {
		return IDuelo.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
