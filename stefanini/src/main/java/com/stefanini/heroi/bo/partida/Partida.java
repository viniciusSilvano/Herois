package com.stefanini.heroi.bo.partida;

import org.springframework.beans.factory.annotation.Autowired;

import com.stefanini.heroi.model.DueloFactory;

public class Partida {
	DueloFactory dueloFactory = DueloFactory.getInstance();
	
	public Partida(){
		Duelo duelo1 = null;
		Duelo duelo2 = null;
		try {
			duelo1 = dueloFactory.getObject();
			duelo2 = dueloFactory.getObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(duelo1 != null && duelo2 != null) {
			System.out.println(duelo1.equals(duelo2));
		}
	}
}
