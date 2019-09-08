package com.stefanini.heroi.service;

import org.springframework.stereotype.Service;

import com.stefanini.heroi.bo.partida.Mutante;
import com.stefanini.heroi.model.factory.EnumTiposPersonagens;
import com.stefanini.heroi.model.factory.IPersonagem;
import com.stefanini.heroi.model.factory.PersonagemFactory;

@Service
public class PersonagemService {
	PersonagemFactory personagemFactory = PersonagemFactory.getInstace();
	public IPersonagem getMutante() throws NullPointerException{
		if(Mutante.getMutante() == null) {
			try {
				return personagemFactory.getObject(
						EnumTiposPersonagens.COMUM,
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
			return Mutante.getMutante();
		}
	}
}
