package com.stefanini.heroi.bo.partida;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.stefanini.heroi.bo.partida.factory.DueloFactory;
import com.stefanini.heroi.model.Personagem;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Partida {
	private DueloFactory dueloFactory = DueloFactory.getInstance();
	private List<Placar> placares = new ArrayList<Placar>();
	
	@Autowired
	private static Personagem MUTANTE;
	
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
					}
					heroi1 = vencedor;
					heroi2 = duelo.randomizarHerois();

					counter++;
				}
				this.setPlacares(duelo.getPlacares());
				this.criarMutante();
				
		}catch(NullPointerException e) {
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void criarMutante() {
		if(MUTANTE == null) {
			System.out.println("Mutante null");
		}
	}
	
}