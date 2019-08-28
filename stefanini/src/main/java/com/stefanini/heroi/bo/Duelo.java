package com.stefanini.heroi.bo;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.stefanini.heroi.model.Personagem;
import com.stefanini.heroi.util.BancoMemoriaUtil;
import com.stefanini.heroi.util.EnumPersonagemHabilidades;
import com.stefanini.heroi.util.EnumPersonagemSituacao;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Duelo {
	
	private BancoMemoriaUtil bancoMemoriaUtil = BancoMemoriaUtil.getInstance();
	private List<Personagem> herois;
	private Random random;
	private Personagem heroi1;
	private Personagem heroi2;
	
	
	public Duelo(Random random) {
		this();
		this.random = random;
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
		escolherHerois(randomizarHerois());
	}
	
	private Personagem randomizarHerois() {
		return this.herois.get(random.nextInt(herois.size()));
	}
	
	private void escolherHerois(Personagem heroi1) {
		this.heroi1 = heroi1;
		this.heroi2 = heroi1;
		while(true) {
			this.heroi2 = randomizarHerois();
			if(this.heroi2.getAlinhamento().equals(this.heroi1.getAlinhamento())
					&& this.heroi1 != heroi2) {
				break;
			}
			
		}
		System.out.println("Heroi 1: " + this.heroi1.getNome() + " Alinhamento: " + this.heroi1.getAlinhamento());
		System.out.println("Heroi 2: " + this.heroi2.getNome() + " Alinhamento: " + this.heroi2.getAlinhamento());
		iniciarPartida();
	}
	
	public void iniciarPartida() {
		switch(EnumPersonagemHabilidades.getRandomHabilidades(this.random)) {
		case INTELIGENCIA:
			System.out.println("Habilidade: Inteligência");
			compararHabilidades(this.heroi1.getInteligencia(), this.heroi2.getInteligencia());
			break;
		case COMBATE:
			System.out.println("Habilidade: Combate");
			compararHabilidades(this.heroi1.getCombate(), this.heroi2.getCombate());
			break;
		case DEFESA:
			System.out.println("Habilidade: Defesa");
			compararHabilidades(this.heroi1.getDefesa(), this.heroi2.getDefesa());
			break;
		case DESTREZA:
			System.out.println("Habilidade: Destreza");
			compararHabilidades(this.heroi1.getDestreza(), this.heroi2.getDestreza());
			break;
		case FORCA:
			System.out.println("Habilidade: Força");
			compararHabilidades(this.heroi1.getForca(), this.heroi2.getForca());
			break;
		case PODER:
			System.out.println("Habilidade: Poder");
			compararHabilidades(this.heroi1.getPoder(), this.heroi2.getPoder());
			break;
		}
	}
	
	private void compararHabilidades(Integer heroi1Hab,Integer heroi2Hab) {
		System.out.println("Pontos do heroi 1: " + heroi1Hab);
		System.out.println("Pontos do heroi 2: " + heroi2Hab);
		if(heroi1Hab.compareTo(heroi2Hab) == 0) {
			this.iniciarPartida();
			System.out.println("Empate");
		}
		else if(heroi1Hab.compareTo(heroi2Hab) > 1) {
			this.heroi1.setSituacao(EnumPersonagemSituacao.VENCEDOR);
			this.heroi2.setSituacao(EnumPersonagemSituacao.PERDEDOR);
			System.out.println("Heroi 1 venceu a partida !!!");
		}else {
			this.heroi2.setSituacao(EnumPersonagemSituacao.VENCEDOR);
			this.heroi1.setSituacao(EnumPersonagemSituacao.PERDEDOR);
			System.out.println("Heroi 2 venceu a partida !!!");
		}
	}
	
	
}
