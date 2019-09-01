package com.stefanini.heroi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stefanini.heroi.bo.partida.Partida;
import com.stefanini.heroi.bo.partida.factory.DueloFactory;
import com.stefanini.heroi.bo.partida.factory.IDuelo;
import com.stefanini.heroi.model.factory.IPersonagem;
import com.stefanini.heroi.model.factory.PersonagemFactory;

@Configuration
public class BeanConfig { 
	    @Bean(name = "duelo")
	    public DueloFactory dueloFactory() {
	        return DueloFactory.getInstance();
	    }
	 
	    @Bean
	    public IDuelo iDuelo() throws Exception {
	        return dueloFactory().getObject();
	    }
	    
	    @Bean
	    public Partida partida(){
	    	return new Partida();
	    }
	    
	    @Bean
	    public PersonagemFactory personagemFactory() {
	    	return PersonagemFactory.getInstace();
	    }
	    
	    @Bean
	    public IPersonagem iPersonagem() throws Exception {
	    	return personagemFactory().getObject();
	    }
}

