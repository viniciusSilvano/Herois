package com.stefanini.heroi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stefanini.heroi.bo.partida.Partida;
import com.stefanini.heroi.bo.partida.factory.PartidaFactory;
import com.stefanini.heroi.dto.PlacarDTO;

@Service
public class PartidaService {
	private PartidaFactory partidaFactory = PartidaFactory.getInstance();
	
	public List<PlacarDTO> iniciarPartidasERetornarPlacar() throws NullPointerException{
		try {
			Partida partida = (Partida) partidaFactory.getObject();
			partida.IniciarPartidas(10);
			return partida.getPlacares();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}