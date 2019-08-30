package com.stefanini.heroi.dto;

import com.stefanini.heroi.model.Personagem;

public class PersonagemDTO {
	private String nome;
	private Integer inteligencia;
	private Integer forca;
	private Integer destreza;
	private Integer poder;
	private Integer combate;
	private Integer defesa;
	
	private PersonagemDTO(String nome,
		Integer inteligencia,
		Integer forca,
		Integer destreza,
		Integer poder,
		Integer combate,
		Integer defesa
	){
		
	}
	
	public PersonagemDTO converterMutanteParaDTO(Personagem personagem) {
		return new PersonagemDTO(personagem.getNome(),
				personagem.getInteligencia(),
				personagem.getForca(),
				personagem.getDestreza(),
				personagem.getPoder(),
				personagem.getCombate(),
				personagem.getDefesa());
	}
}
