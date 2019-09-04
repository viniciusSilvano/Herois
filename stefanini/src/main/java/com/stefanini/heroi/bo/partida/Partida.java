package com.stefanini.heroi.bo.partida;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.stefanini.heroi.bo.partida.factory.DueloFactory;
import com.stefanini.heroi.bo.partida.factory.IPartida;
import com.stefanini.heroi.dto.PlacarDTO;
import com.stefanini.heroi.model.Personagem;
import com.stefanini.heroi.model.factory.PersonagemFactory;
import com.stefanini.heroi.util.GlobalStrings;
import com.stefanini.heroi.util.PersonagemUtil;

public class Partida implements IPartida {
	private DueloFactory dueloFactory = DueloFactory.getInstance();
	private PersonagemFactory personagemFactory = PersonagemFactory.getInstace();
	private List<PlacarDTO> placares = new ArrayList<>();
	private Logger logger = Logger.getLogger(Partida.class);
	private static Personagem mutante;
	private Personagem primeiroLugar;
	private Personagem segundoLugar;
			
	public List<PlacarDTO> getPlacares() {
		return placares;
	}
	
	private Personagem getPrimeiroLugar() {
		return primeiroLugar;
	}

	private void setPrimeiroLugar(Personagem primeiroLugar) {
		this.primeiroLugar = primeiroLugar;
	}

	private Personagem getSegundoLugar() {
		return segundoLugar;
	}

	private void setSegundoLugar(Personagem segundoLugar) {
		this.segundoLugar = segundoLugar;
	}

	public void setPlacares(List<PlacarDTO> placares) {
		this.placares = placares;
		
	}
	
	public static Personagem getMutante() {
		return mutante;
	}

	public static void setMutante(Personagem mutante) {
		Partida.mutante = mutante;
	}
	
	public void iniciarPartidas(int quantidade) {

		try {
			
			Duelo duelo = null;
			int counter = 0;
			
			if(  dueloFactory.getObject() instanceof Duelo) {
				duelo = (Duelo) dueloFactory.getObject();
			}
				//Randomizar dois herois aleatórios
				Personagem heroi1 = duelo.randomizarHerois();
				Personagem heroi2 = duelo.randomizarHerois();
				logger.info(GlobalStrings.DASH);
				logger.info("INICIANDO PARTIDAS");
				logger.info(GlobalStrings.DASH);

				//iniciar a contagem das 10s partidas
				while(counter < quantidade) {
					//validar herois.
					while(!duelo.validarHerois(heroi1, heroi2)) {
						heroi2 = duelo.randomizarHerois();
					}
					logger.info(GlobalStrings.LINE_SEPARATOR);
					logger.info("Heroi 1: " + heroi1.getNome());
					logger.info("Heroi 2: " + heroi2.getNome());
					logger.info(GlobalStrings.LINE_SEPARATOR);
					//iniciar combates e definir vencedores e perdedores
					Personagem vencedor = duelo.iniciarCombate(heroi1, heroi2);
					int tentativasDeDesempate = 0;
					//enquanto o vencedor não for definido reinicie o combate
					while(vencedor == null) {
						vencedor = duelo.iniciarCombate(heroi1, heroi2);
						//se não desempatar após 3 tentativas traga um novo heroi.
						if(tentativasDeDesempate > 3) {
							heroi2 = duelo.randomizarHerois();
							tentativasDeDesempate = 0;
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
			logger.error("Null pointer ao tentar iniciar as Partidas");
		}catch(ClassCastException e) {
			logger.error("class cast exception ao tentar iniciar as Partidas");
		}
		catch (Exception e) {
			logger.error("Ocorreu um erro ao tentar iniciar as partidas");
		}
		
	}
	
	private void definirSegundoEPrimerioLugar() {
		try {	
			List<Personagem> personagensVencedores = this.getPlacares().stream().map(PlacarDTO::getVencedor)
					.collect(Collectors.toList());
					
			this.setPrimeiroLugar(personagensVencedores.stream()
					.max((x,y) -> x.getVitorias().compareTo(y.getVitorias())).orElseThrow(
							() -> new IllegalStateException("não há um vencedor")));
					
			this.setSegundoLugar(personagensVencedores.stream()
					.filter(x -> !x.equals(this.getPrimeiroLugar()))
					.max((x,y) -> x.getVitorias().compareTo(y.getVitorias()))
					.orElse( (Personagem) personagemFactory
							.getObject("N/A", "N/A", 
									Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), 
									Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0))));
			
			logger.info(GlobalStrings.LINE_SEPARATOR);
			logger.info(GlobalStrings.DASH);
			logger.info("COLOCAÇÕES PRINCIPAIS");
			logger.info(GlobalStrings.DASH);
			logger.info("Primeiro lugar:" + primeiroLugar);
			logger.info(GlobalStrings.LINE_SEPARATOR);
			logger.info("Segundo lugar:" + segundoLugar);
			
		}catch(NullPointerException e) {
			logger.error("null exception ao tentar definir os dois herois vitoriosos");
		}catch(NoSuchElementException e) {
			logger.error("Erro no stream ao tentar definir os dois herois vitoriosos");
		}catch(IndexOutOfBoundsException e) {
			logger.error("Erro ao tentar recuperar os dois herois vitoriosos da lista");
		}catch(Exception e) {
			logger.error("Erro ao tentar definir os dois herois vitoriosos");
		}
	}
	
	private void criarMutante() {
		try {
			Partida.setMutante((Personagem) personagemFactory.getObject());
		}catch (ClassCastException e) {
			logger.error("Erro de abstração ao tentar criar o mutante");
		} 
		catch (Exception e) {
			logger.error("Erro ao tentar criar mutante");
		}
		Partida.getMutante().setNome("O Mutante");
		Partida.getMutante().setCombate(PersonagemUtil.PersonagemComparator(this.getPrimeiroLugar(),this.getSegundoLugar(),
				this.getPrimeiroLugar().getCombate() ,this.getSegundoLugar().getCombate()).getCombate());
		
		Partida.getMutante().setDefesa(PersonagemUtil.PersonagemComparator(this.getPrimeiroLugar(),this.getSegundoLugar() ,
				this.getPrimeiroLugar().getDefesa() ,this.getSegundoLugar().getDefesa()).getDefesa());
		
		Partida.getMutante().setDestreza(PersonagemUtil.PersonagemComparator(this.getPrimeiroLugar(),this.getSegundoLugar() ,
				this.getPrimeiroLugar().getDestreza() ,this.getSegundoLugar().getDestreza()).getDestreza());
		
		Partida.getMutante().setForca(PersonagemUtil.PersonagemComparator(this.getPrimeiroLugar(),this.getSegundoLugar() ,
				this.getPrimeiroLugar().getForca() ,this.getSegundoLugar().getForca()).getForca());
		
		Partida.getMutante().setInteligencia(PersonagemUtil.PersonagemComparator(this.getPrimeiroLugar(),this.getSegundoLugar() ,
				this.getPrimeiroLugar().getInteligencia() ,this.getSegundoLugar().getInteligencia()).getInteligencia());
		
		Partida.getMutante().setPoder(PersonagemUtil.PersonagemComparator(this.getPrimeiroLugar(),this.getSegundoLugar() ,
				this.getPrimeiroLugar().getPoder() ,this.getSegundoLugar().getPoder()).getPoder());
		
		logger.info("Mutante criado: " + Partida.getMutante());
	}
	
}
