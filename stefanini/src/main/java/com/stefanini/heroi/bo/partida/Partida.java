package com.stefanini.heroi.bo.partida;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.stefanini.heroi.bo.partida.factory.DueloFactory;
import com.stefanini.heroi.model.Personagem;
import com.stefanini.heroi.model.factory.PersonagemFactory;
import com.stefanini.heroi.util.PersonagemUtil;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Partida {
	private DueloFactory dueloFactory = DueloFactory.getInstance();
	private PersonagemFactory personagemFactory = PersonagemFactory.getInstace();
	private List<Placar> placares = new ArrayList<Placar>();
	
	private static Personagem MUTANTE;
	private Personagem primeiroLugar;
	private Personagem segundoLugar;
	
	public Partida(){
		
	}
	
	
	
	public List<Placar> getPlacares() {
		return placares;
	}



	public void setPlacares(List<Placar> placares) {
		this.placares = placares;
	}



	public void IniciarPartidas(int quantidade) {

		try {
			
			Duelo duelo = null;
			int counter = 0;
			
			if(  dueloFactory.getObject() instanceof Duelo) {
				duelo = (Duelo) dueloFactory.getObject();
			}
				//Randomizar dois herois aleatórios
				Personagem heroi1 = duelo.randomizarHerois();
				Personagem heroi2 = duelo.randomizarHerois();
				System.out.println("-----------------------------------------------------");
				System.out.println("INICIANDO PARTIDAS");
				System.out.println("-----------------------------------------------------");

				//iniciar a contagem das 10s partidas
				while(counter < quantidade) {
					//validar herois.
					while(!duelo.validarHerois(heroi1, heroi2)) {
						heroi2 = duelo.randomizarHerois();
					}
					System.out.println();
					System.out.println("Heroi 1: " + heroi1.getNome());
					System.out.println("Heroi 2: " + heroi2.getNome());
					System.out.println();
					//iniciar combates e definir vencedores e perdedores
					Personagem vencedor = duelo.iniciarCombate(heroi1, heroi2);
					int tentativasDeDesempate = 0;
					while(vencedor == null) {
						vencedor = duelo.iniciarCombate(heroi1, heroi2);
						if(tentativasDeDesempate > 3) {
							heroi2 = duelo.randomizarHerois();
						}
						tentativasDeDesempate++;
					}
					heroi1 = vencedor;
					heroi2 = duelo.randomizarHerois();

					counter++;
				}
				this.setPlacares(duelo.getPlacares());
				this.definirSegundoEPrimerioLugar();
				this.criarMutante();
				
		}catch(NullPointerException e) {
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void definirSegundoEPrimerioLugar() {
		try {	
			List<Personagem> personagensVencedores = placares.stream().map(Placar::getVencedor)
					.collect(Collectors.toList());
					
			this.primeiroLugar = personagensVencedores.stream()
					.max((x,y) -> x.getVitorias().compareTo(y.getVitorias())).get();
					
			this.segundoLugar = personagensVencedores.stream()
					.filter(x -> !x.equals(primeiroLugar))
					.max((x,y) -> x.getVitorias().compareTo(y.getVitorias())).get();
			
			System.out.println();
			System.out.println("-----------------------------------------------------");
			System.out.println("COLOCAÇÕES PRINCIPAIS");
			System.out.println("-----------------------------------------------------");
			System.out.println("Primeiro lugar:" + primeiroLugar);
			System.out.println();
			System.out.println("Segundo lugar:" + segundoLugar);
			
		}catch(NullPointerException e) {
			e.printStackTrace();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	private void criarMutante() {
		try {
			MUTANTE = (Personagem) personagemFactory.getObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MUTANTE.setNome("O Mutante");
		MUTANTE.setCombate(PersonagemUtil.PersonagemComparator(primeiroLugar,segundoLugar ,
				primeiroLugar.getCombate() ,segundoLugar.getCombate()).getCombate());
		
		MUTANTE.setDefesa(PersonagemUtil.PersonagemComparator(primeiroLugar,segundoLugar ,
				primeiroLugar.getDefesa() ,segundoLugar.getDefesa()).getDefesa());
		
		MUTANTE.setDestreza(PersonagemUtil.PersonagemComparator(primeiroLugar,segundoLugar ,
				primeiroLugar.getDestreza() ,segundoLugar.getDestreza()).getDestreza());
		
		MUTANTE.setForca(PersonagemUtil.PersonagemComparator(primeiroLugar,segundoLugar ,
				primeiroLugar.getForca() ,segundoLugar.getForca()).getForca());
		
		MUTANTE.setInteligencia(PersonagemUtil.PersonagemComparator(primeiroLugar,segundoLugar ,
				primeiroLugar.getInteligencia() ,segundoLugar.getInteligencia()).getInteligencia());
		
		MUTANTE.setPoder(PersonagemUtil.PersonagemComparator(primeiroLugar,segundoLugar ,
				primeiroLugar.getPoder() ,segundoLugar.getPoder()).getPoder());
		
		System.out.println("Mutante criado: " + MUTANTE);
	}
	
}
