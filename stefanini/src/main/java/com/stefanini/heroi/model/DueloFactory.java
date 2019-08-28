package com.stefanini.heroi.model;

import java.util.Random;

import org.springframework.beans.factory.FactoryBean;

import com.stefanini.heroi.bo.partida.Duelo;

public class DueloFactory implements FactoryBean<Duelo> {
	private static Random random = new Random();
	
	@Override
	public Duelo getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Duelo(random);
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Duelo.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
