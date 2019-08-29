package com.stefanini.heroi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stefanini.heroi.bo.partida.Duelo;
import com.stefanini.heroi.bo.partida.DueloFactory;
import com.stefanini.heroi.bo.partida.IDuelo;
import com.stefanini.heroi.bo.partida.Partida;

@Configuration
public class BeanConfig { 
	    @Bean(name = "duelo")
	    public DueloFactory dueloFactory() {
	        DueloFactory factory = new DueloFactory();
	        return factory;
	    }
	 
	    @Bean
	    public IDuelo iDuelo() throws Exception {
	        return dueloFactory().getObject();
	    }
	    
	    @Bean
	    public Partida partida() throws Exception{
	    	return new Partida();
	    }
}

