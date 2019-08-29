package com.stefanini.heroi.bo.partida;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.stefanini.heroi.bo.partida.factory.IDuelo;
import com.stefanini.heroi.model.Personagem;
import com.stefanini.heroi.util.BancoMemoriaUtil;
import com.stefanini.heroi.util.EnumPersonagemHabilidades;
import com.stefanini.heroi.util.EnumPersonagemSituacao;

@Component
public class Duelo  implements IDuelo{
	
	private List<Personagem> herois;
	private Random random;
	private List<Placar> placares = new ArrayList<Placar>();
	
	public Duelo() {
		
	}
	public Duelo(Random random) {
		this.random = random;
		this.InicializarListaDeHerois();
	}
			
	public List<Placar> getPlacares() {
		return placares;
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
	
	private void ModificarAtributos(Personagem heroi1,Personagem heroi2) {
		
	}
	
	//retorna o heroi vencedor
	protected Personagem iniciarCombate(Personagem heroi1, Personagem heroi2) throws NullPointerException {
		Personagem resultado;
		switch(EnumPersonagemHabilidades.getRandomHabilidades(this.random)) {
		case INTELIGENCIA:
			System.out.println("Habilidade: Inteligência");
			resultado = compararHabilidades(
					heroi1.getInteligencia(), 
					heroi2.getInteligencia(),
					heroi1,
					heroi2,
					EnumPersonagemHabilidades.INTELIGENCIA
					);
			if(resultado != null) {
				if(resultado == heroi1) {
					heroi1.setInteligencia(heroi1.getInteligencia() + 2);
					heroi2.setInteligencia(heroi2.getInteligencia() - 2);
					System.out.println();
				}else {
					heroi1.setInteligencia(heroi1.getInteligencia() - 2);
					heroi2.setInteligencia(heroi2.getInteligencia() + 2);
				}
				System.out.println("Novo ponto do vencedor: " + resultado.getNome() + " agora possui:" + resultado.getInteligencia());
			}
			return resultado;
		case COMBATE:
			System.out.println("Habilidade: Combate");
			resultado = compararHabilidades(
					heroi1.getCombate(), 
					heroi2.getCombate(),
					heroi1,
					heroi2,
					EnumPersonagemHabilidades.COMBATE
					);
			if(resultado != null) {
				if(resultado == heroi1) {
					heroi1.setCombate(heroi1.getCombate() + 2);
					heroi2.setCombate(heroi2.getCombate() - 2);
				}else {
					heroi1.setCombate(heroi1.getCombate() - 2);
					heroi2.setCombate(heroi2.getCombate() + 2);
				}
				System.out.println("Novo ponto do vencedor: " + resultado.getNome() + " agora possui:" + resultado.getCombate());
			}
			return resultado;
		case DEFESA:
			System.out.println("Habilidade: Defesa");
			resultado = compararHabilidades(
					heroi1.getDefesa(), 
					heroi2.getDefesa(),
					heroi1,
					heroi2,
					EnumPersonagemHabilidades.DEFESA
					);
			if(resultado != null) {
				if(resultado == heroi1) {
					heroi1.setDefesa(heroi1.getDefesa() + 2);
					heroi2.setDefesa(heroi2.getDefesa() - 2);
				}else {
					heroi1.setDefesa(heroi1.getDefesa() - 2);
					heroi2.setDefesa(heroi2.getDefesa() + 2);
				}
				System.out.println("Novo ponto do vencedor: " + resultado.getNome() + " agora possui:" + resultado.getDefesa());
			}
			return resultado;
		case DESTREZA:
			System.out.println("Habilidade: Destreza");
			resultado = compararHabilidades(
					heroi1.getDestreza(), 
					heroi2.getDestreza(),
					heroi1,
					heroi2,
					EnumPersonagemHabilidades.DESTREZA
					);
			if(resultado != null) {
				if(resultado == heroi1) {
					heroi1.setDestreza(heroi1.getDestreza() + 2);
					heroi2.setDestreza(heroi2.getDestreza() - 2);
				}else {
					heroi1.setDestreza(heroi1.getDestreza() - 2);
					heroi2.setDestreza(heroi2.getDestreza() + 2);
				}
				System.out.println("Novo ponto do vencedor: " + resultado.getNome() + " agora possui:" + resultado.getDestreza());
			}
			return resultado;
		case FORCA:
			System.out.println("Habilidade: Força");
			resultado = compararHabilidades(
					heroi1.getForca(), 
					heroi2.getForca(),
					heroi1,
					heroi2,
					EnumPersonagemHabilidades.FORCA
					);
			if(resultado != null) {
				if(resultado == heroi1) {
					heroi1.setForca(heroi1.getForca() + 2);
					heroi2.setForca(heroi2.getForca() - 2);
				}else {
					heroi1.setForca(heroi1.getForca() - 2);
					heroi2.setForca(heroi2.getForca() + 2);
				}
				System.out.println("Novo ponto do vencedor: " + resultado.getNome() + " agora possui:" + resultado.getForca());
			}
			return resultado;
		case PODER:
			System.out.println("Habilidade: Poder");
			resultado = compararHabilidades(
					heroi1.getPoder(), 
					heroi2.getPoder(),
					heroi1,
					heroi2,
					EnumPersonagemHabilidades.PODER
					);
			if(resultado != null) {
				if(resultado == heroi1) {
					heroi1.setPoder(heroi1.getPoder() + 2);
					heroi2.setPoder(heroi2.getPoder() - 2);
				}else {
					heroi1.setPoder(heroi1.getPoder() - 2);
					heroi2.setPoder(heroi2.getPoder() + 2);
				}
				System.out.println("Novo ponto do vencedor: " + resultado.getNome() + " agora possui:" + resultado.getPoder());
			}
			return resultado;
		}
		return null;
	}
	
	//retorna o heroi vencedor ou em caso de empate null
	private Personagem compararHabilidades(Integer heroi1Hab,Integer heroi2Hab,
			Personagem heroi1,Personagem heroi2, EnumPersonagemHabilidades habilidadeEscolhida) throws NullPointerException {
		System.out.println("Pontos do heroi 1: " + heroi1Hab);
		System.out.println("Pontos do heroi 2: " + heroi2Hab);
		int resultado = heroi1Hab.compareTo(heroi2Hab);
		switch(resultado) {
			case 0:
				System.out.println("Empate");
				heroi1.setSituacao(EnumPersonagemSituacao.INDIFERENTE);
				heroi2.setSituacao(EnumPersonagemSituacao.INDIFERENTE);
				return null;
			case 1:
				heroi1.setSituacao(EnumPersonagemSituacao.VENCEDOR);
				heroi2.setSituacao(EnumPersonagemSituacao.PERDEDOR);
				System.out.println("Heroi 1 venceu a partida !!!");
				heroi1.setVitorias(heroi1.getVitorias().intValue() + 1);
				placares.add(new Placar(heroi1,heroi2,heroi1Hab,heroi2Hab,habilidadeEscolhida));
				return heroi1;
			case -1:
				heroi2.setSituacao(EnumPersonagemSituacao.VENCEDOR);
				heroi1.setSituacao(EnumPersonagemSituacao.PERDEDOR);
				System.out.println("Heroi 2 venceu a partida !!!");
				heroi2.setVitorias(heroi2.getVitorias().intValue() + 1);
				placares.add(new Placar(heroi2,heroi1,heroi2Hab,heroi1Hab,habilidadeEscolhida));
				return heroi2;
			default:
				return null;
		}
		
	}	
}
