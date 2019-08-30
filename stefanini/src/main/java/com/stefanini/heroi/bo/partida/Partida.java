package com.stefanini.heroi.bo.partida;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.stefanini.heroi.bo.partida.factory.DueloFactory;
import com.stefanini.heroi.bo.partida.factory.IPartida;
import com.stefanini.heroi.dto.PlacarDTO;
import com.stefanini.heroi.model.Personagem;
import com.stefanini.heroi.model.factory.PersonagemFactory;
import com.stefanini.heroi.util.PersonagemUtil;

public class Partida implements IPartida {
	private DueloFactory dueloFactory = DueloFactory.getInstance();
	private PersonagemFactory personagemFactory = PersonagemFactory.getInstace();
	private List<PlacarDTO> placares = new ArrayList<PlacarDTO>();
	
	public static Personagem MUTANTE;
	private Personagem primeiroLugar;
	private Personagem segundoLugar;
	
	public Partida(){
		
	}
		
	public List<PlacarDTO> getPlacares() {
		return placares;
	}


	public void setPlacares(List<PlacarDTO> placares) {
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
					//enquanto o vencedor não for definido reinicie o combate
					while(vencedor == null) {
						vencedor = duelo.iniciarCombate(heroi1, heroi2);
						//se não desempatar após 3 tentativas traga um novo heroi.
						if(tentativasDeDesempate > 3) {
							heroi2 = duelo.randomizarHerois();
						}
						tentativasDeDesempate++;
					}
					heroi1 = vencedor;
					heroi2 = duelo.randomizarHerois();

					counter++;
				}
				//Depois de terminada as partidas definimos os placares
				this.setPlacares(duelo.getPlacares());
				//definimos o primeiro e segundo lugar
				this.definirSegundoEPrimerioLugar();
				//e por ultimo criamos o mutante
				this.criarMutante();
				
		}catch(NullPointerException e) {
			e.printStackTrace();
		}catch(ClassCastException e) {
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void definirSegundoEPrimerioLugar() {
		try {	
			List<Personagem> personagensVencedores = placares.stream().map(PlacarDTO::getVencedor)
					.collect(Collectors.toList());
					
			this.primeiroLugar = personagensVencedores.stream()
					.max((x,y) -> x.getVitorias().compareTo(y.getVitorias())).get();
					
			segundoLugar = personagensVencedores.stream()
					.filter(x -> !x.equals(primeiroLugar))
					.max((x,y) -> x.getVitorias().compareTo(y.getVitorias()))
					.orElse( (Personagem) personagemFactory
							.getObject("N/A", "N/A", 
									Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), 
									Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)));
			
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
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void criarMutante() {
		try {
			MUTANTE = (Personagem) personagemFactory.getObject();
		}catch (ClassCastException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
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
