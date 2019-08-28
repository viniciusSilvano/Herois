package com.stefanini.heroi.bo;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.stefanini.heroi.dto.PersonagemDto;
import com.stefanini.heroi.util.BancoMemoriaUtil;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Duelo {
	
	private BancoMemoriaUtil bancoMemoriaUtil = BancoMemoriaUtil.getInstance();
	private List<PersonagemDto> herois;
	private Random random;
	Partida partida;
	
	public Duelo(Random random, Partida partida) {
		InicializarListaDeHerois();
		this.random = random;
		this.partida = partida;
	}
	
	public Duelo() {
		
	}
	
	private void InicializarListaDeHerois() {
		try {
			this.herois = bancoMemoriaUtil.carregaPersonagens();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void prepararPartida() {
		diferenciarAlinhamento(randomizarHerois());
	}
	
	private PersonagemDto randomizarHerois() {
		return this.herois.get(random.nextInt(herois.size()));
	}
	
	private void diferenciarAlinhamento(PersonagemDto heroi1) {
		PersonagemDto herois2 = heroi1;
		while(heroi1.getAlinhamento() == herois2.getAlinhamento()) {
			
		}
	}
}
