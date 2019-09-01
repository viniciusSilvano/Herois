package com.stefanini.heroi.service;

import org.springframework.stereotype.Service;

import com.stefanini.heroi.bo.partida.Partida;
import com.stefanini.heroi.model.Personagem;
import com.stefanini.heroi.model.factory.PersonagemFactory;

@Service
public class PersonagemService {
	PersonagemFactory personagemFactory = PersonagemFactory.getInstace();
	public Personagem getMutante() throws NullPointerException{
		if(Partida.getMutante() == null) {
			try {
				return (Personagem) personagemFactory.getObject(
						"N/A",
						"N/A",
						Integer.valueOf(0),
						Integer.valueOf(0),
						Integer.valueOf(0),
						Integer.valueOf(0),
						Integer.valueOf(0),
						Integer.valueOf(0));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}else {
			return Partida.getMutante();
		}
	}
}
