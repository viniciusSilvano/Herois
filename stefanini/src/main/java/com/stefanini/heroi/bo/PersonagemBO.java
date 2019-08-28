package com.stefanini.heroi.bo;

import java.io.IOException;
import java.util.List;

import com.stefanini.heroi.model.Personagem;
import com.stefanini.heroi.util.BancoMemoriaUtil;

/**
 * Classe responsável pelos personagens
 * @author paulo
 *
 */

public class PersonagemBO {

	/**
	 * Carrega dados dos personagens na memória
	 * @return
	 * @throws IOException
	 */
	public List<Personagem> carregarPersonagem() throws IOException{
		return BancoMemoriaUtil.getInstance().carregaPersonagens();
	}
	
}