package com.stefanini.heroi.bo.partida;

import com.stefanini.heroi.model.Personagem;
import com.stefanini.heroi.util.EnumPersonagemHabilidades;

public class Placar {
	private Personagem vencedor;
	private Personagem perdedor;
	private EnumPersonagemHabilidades habilidade;
	private Integer vencedorHabilidadeValor;
	private Integer perdedorHabilidadeValor;
	
	public Placar(Personagem vencedor, Personagem perdedor,
			Integer vencedorHabilidadeValor, Integer perdedorHabilidadeValor, EnumPersonagemHabilidades habilidade) {
		this.vencedor = vencedor;
		this.perdedor = perdedor;
		this.vencedorHabilidadeValor = vencedorHabilidadeValor;
		this.perdedorHabilidadeValor = perdedorHabilidadeValor;
		this.habilidade = habilidade;
	}

	public Personagem getVencedor() {
		return vencedor;
	}

	public Personagem getPerdedor() {
		return perdedor;
	}

	public EnumPersonagemHabilidades getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(EnumPersonagemHabilidades habilidade) {
		this.habilidade = habilidade;
	}

	public Integer getVencedorHabilidadeValor() {
		return vencedorHabilidadeValor;
	}

	public void setVencedorHabilidadeValor(Integer vencedorHabilidadeValor) {
		this.vencedorHabilidadeValor = vencedorHabilidadeValor;
	}

	public Integer getPerdedorHabilidadeValor() {
		return perdedorHabilidadeValor;
	}

	public void setPerdedorHabilidadeValor(Integer perdedorHabilidadeValor) {
		this.perdedorHabilidadeValor = perdedorHabilidadeValor;
	}		
}
