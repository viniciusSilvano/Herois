package com.stefanini.heroi.bo.partida;

import com.stefanini.heroi.model.DueloFactory;

public class Partida {
	DueloFactory dueloFactory = DueloFactory.getInstance();
	
	public Partida(){
		
	}
	
	public void IniciarPartidas(int quantidade) {
		int counter = 0;
		//while(counter < quantidade) {
			try {
				Duelo duelo = dueloFactory.getObject();
				duelo.prepararPartida();
				duelo.iniciarPartida();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//}
	}
}
