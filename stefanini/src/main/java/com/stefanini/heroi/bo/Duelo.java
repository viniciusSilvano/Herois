package com.stefanini.heroi.bo;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.stefanini.heroi.model.Personagem;
import com.stefanini.heroi.util.BancoMemoriaUtil;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Duelo {
	
	private BancoMemoriaUtil bancoMemoriaUtil = BancoMemoriaUtil.getInstance();
	private List<Personagem> herois;
	private Random random;
	Partida partida;
	
	public Duelo(Random random, Partida partida) {
		this();
		this.random = random;
		this.partida = partida;
	}
	
	public Duelo() {
		InicializarListaDeHerois();
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
	
	private Personagem randomizarHerois() {
		return this.herois.get(random.nextInt(herois.size()));
	}
	
	private void diferenciarAlinhamento(Personagem heroi1) {
		Personagem heroi2 = heroi1;
		while(true) {
			heroi2 = randomizarHerois();
			if(heroi2.getAlinhamento() != heroi1.getAlinhamento()
					&& heroi1 != heroi2) {
				break;
			}
			
		}
		System.out.println("Heroi 1: " + heroi1.getNome() + " Alinhamento: " + heroi1.getAlinhamento());
		System.out.println("Heroi 2: " + heroi2.getNome() + " Alinhamento: " + heroi2.getAlinhamento());
		
	}
}
