package com.stefanini.heroi.bo.partida.factory;

import org.springframework.beans.factory.FactoryBean;

import com.stefanini.heroi.bo.partida.Partida;

public class PartidaFactory implements FactoryBean<IPartida> {
	private static PartidaFactory instance;
	
	public static PartidaFactory getInstance() {
		if(instance == null) {
			instance = new PartidaFactory();
			return instance;
		}else {
			return instance;
		}
	}
	
	@Override
	public IPartida getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Partida();
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return IPartida.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
