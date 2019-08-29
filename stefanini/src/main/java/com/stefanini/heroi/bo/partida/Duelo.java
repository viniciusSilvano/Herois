package com.stefanini.heroi.bo.partida;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import com.stefanini.heroi.model.Personagem;
import com.stefanini.heroi.util.BancoMemoriaUtil;
import com.stefanini.heroi.util.EnumPersonagemHabilidades;
import com.stefanini.heroi.util.EnumPersonagemSituacao;

public class Duelo  implements IDuelo{
	
	private List<Personagem> herois;
	private Random random;
	
	public Duelo() {
		
	}
	public Duelo(Random random) {
		this.random = random;
		this.InicializarListaDeHerois();
	}
		
	private void InicializarListaDeHerois() {
		try {
			BancoMemoriaUtil bancoMemoriaUtil = BancoMemoriaUtil.getInstance();
			this.herois = bancoMemoriaUtil.carregaPersonagens();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	protected Personagem randomizarHerois() {
		return this.herois.get(random.nextInt(herois.size()));
	}
	
	protected boolean validarHerois(Personagem heroi1, Personagem heroi2 ) {
		if((!heroi2.getAlinhamento().equals(heroi1.getAlinhamento()))
				&& heroi1 != heroi2) {
			return true;
		}
		return false;
	}
	
	/*private void escolherHerois(Personagem heroi1) {
		this.heroi1 = heroi1;
		this.heroi2 = heroi1;
		boolean condicao = true;
		while(condicao) {
			this.heroi2 = randomizarHerois();
			
			
		}
		System.out.println("Heroi 1: " + this.heroi1.getNome() + " Alinhamento: " + this.heroi1.getAlinhamento());
		System.out.println("Heroi 2: " + this.heroi2.getNome() + " Alinhamento: " + this.heroi2.getAlinhamento());
		//iniciarPartida();
	}*/
	
	//retorna o heroi vencedor
	protected Personagem iniciarCombate(Personagem heroi1, Personagem heroi2) throws NullPointerException {
		switch(EnumPersonagemHabilidades.getRandomHabilidades(this.random)) {
		case INTELIGENCIA:
			System.out.println("Habilidade: Inteligência");
			return compararHabilidades(
					heroi1.getInteligencia(), 
					heroi2.getInteligencia(),
					heroi1,
					heroi2
					);
		case COMBATE:
			System.out.println("Habilidade: Combate");
			return compararHabilidades(
					heroi1.getCombate(), 
					heroi2.getCombate(),
					heroi1,
					heroi2
					);
		case DEFESA:
			System.out.println("Habilidade: Defesa");
			return compararHabilidades(
					heroi1.getDefesa(), 
					heroi2.getDefesa(),
					heroi1,
					heroi2);
		case DESTREZA:
			System.out.println("Habilidade: Destreza");
			return compararHabilidades(
					heroi1.getDestreza(),
					heroi2.getDestreza(),
					heroi1,
					heroi2);
		case FORCA:
			System.out.println("Habilidade: Força");
			return compararHabilidades(
					heroi1.getForca(),
					heroi2.getForca(),
					heroi1,
					heroi2);
		case PODER:
			System.out.println("Habilidade: Poder");
			return compararHabilidades(
					heroi1.getPoder(),
					heroi2.getPoder(),
					heroi1,
					heroi2);
		}
		return null;
	}
	
	//retorna o heroi vencedor ou em caso de empate null
	private Personagem compararHabilidades(Integer heroi1Hab,Integer heroi2Hab,Personagem heroi1,Personagem heroi2) throws NullPointerException {
		System.out.println("Pontos do heroi 1: " + heroi1Hab);
		System.out.println("Pontos do heroi 2: " + heroi2Hab);
		if(heroi1Hab == heroi2Hab) {
			return null;
		}
		else if(heroi1Hab > heroi2Hab ) {
			heroi1.setSituacao(EnumPersonagemSituacao.VENCEDOR);
			heroi2.setSituacao(EnumPersonagemSituacao.PERDEDOR);
			System.out.println("Heroi 1 venceu a partida !!!");
			return heroi1;
		}else {
			heroi2.setSituacao(EnumPersonagemSituacao.VENCEDOR);
			heroi1.setSituacao(EnumPersonagemSituacao.PERDEDOR);
			System.out.println("Heroi 2 venceu a partida !!!");
			return heroi2;
			
		}
	}
	
	
}
