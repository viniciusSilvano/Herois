package com.stefanini.heroi.bo.partida.factory;

import java.util.List;

import com.stefanini.heroi.dto.PlacarDTO;
import com.stefanini.heroi.model.factory.IPersonagem;

public interface IDuelo {
	List<PlacarDTO> getPlacares();
}
