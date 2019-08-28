package com.stefanini.heroi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stefanini.heroi.bo.partida.Duelo;
import com.stefanini.heroi.model.DueloFactory;

@Configuration
public class FactoryBeanConfig { 
	    @Bean(name = "duelo")
	    public DueloFactory dueloFactory() {
	        DueloFactory factory = new DueloFactory();
	        return factory;
	    }
	 
	    @Bean
	    public Duelo duelo() throws Exception {
	        return dueloFactory().getObject();
	    }
}

