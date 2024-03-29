package com.stefanini.heroi.model.factory;

import org.springframework.beans.factory.FactoryBean;

import com.stefanini.heroi.model.Personagem;


public class PersonagemFactory implements FactoryBean<IPersonagem> {
	
	private static PersonagemFactory personagemFactory;
	
	public PersonagemFactory() {
		
	}
	
	public static PersonagemFactory getInstace() {
		if(personagemFactory == null) {
			personagemFactory = new PersonagemFactory();
			return personagemFactory;
		}else {
			return personagemFactory;
		}
	}
	
	@Override
	public IPersonagem getObject() throws Exception {
		return new Personagem();
	}
	
	public IPersonagem getObject(EnumTiposPersonagens tipo,String nome, String alinhamento, Integer inteligencia,
			Integer forca, Integer destreza, Integer poder, Integer combate, Integer defesa) throws Exception{
		switch(tipo) {
		
			case COMUM:
				return new Personagem(nome, alinhamento, inteligencia, forca, destreza, poder, combate, defesa);
			default:
				return new Personagem(nome, alinhamento, inteligencia, forca, destreza, poder, combate, defesa);
		}
		
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return IPersonagem.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
