package com.stefanini.heroi.bo.partida.factory;

import java.util.List;

import com.stefanini.heroi.dto.PlacarDTO;
import com.stefanini.heroi.model.factory.IPersonagem;

public interface IDuelo {
	IPersonagem randomizarHerois();

	boolean validarHerois(IPersonagem heroi1, IPersonagem heroi2);

	List<PlacarDTO> getPlacares();

	IPersonagem iniciarCombate(IPersonagem heroi1, IPersonagem heroi2);
}
