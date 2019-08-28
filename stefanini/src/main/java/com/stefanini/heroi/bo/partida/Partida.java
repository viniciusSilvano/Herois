package com.stefanini.heroi.bo.partida;

import com.stefanini.heroi.model.DueloFactory;
import com.stefanini.heroi.model.Personagem;

public class Partida {
	private DueloFactory dueloFactory = DueloFactory.getInstance();
	private Personagem heroiVencedor;
	private int counter = 0;
	public Partida(){
		
	}
	
	public void IniciarPartidas(int quantidade) {
		try {
			Duelo duelo = dueloFactory.getObject();
			while(counter < quantidade) {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
