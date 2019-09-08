package com.stefanini.heroi.bo.partida.factory;

import java.util.List;
import com.stefanini.heroi.dto.PlacarDTO;


public interface IPartida {
	List<PlacarDTO> getPlacares();
	

	void setPlacares(List<PlacarDTO> placares);
		
	void iniciarPartidas(int quantidade);
	
}
