package com.stefanini.heroi.dto;

import java.io.Serializable;

import com.stefanini.heroi.model.factory.EnumTiposPersonagens;
import com.stefanini.heroi.model.factory.IPersonagem;
import com.stefanini.heroi.util.enuns.EnumPersonagemHabilidades;

public class PlacarDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3214932952899046334L;
	private PersonagemDTO vencedor;
	private PersonagemDTO perdedor;
	private EnumPersonagemHabilidades habilidade;
	private Integer vencedorHabilidadeValor;
	private Integer perdedorHabilidadeValor;
	
	public PlacarDTO(IPersonagem vencedor, IPersonagem perdedor,
			Integer vencedorHabilidadeValor, Integer perdedorHabilidadeValor, EnumPersonagemHabilidades habilidade) {
		this.vencedor = PersonagemDTO.converterPersonagemParaDTO(vencedor);
		this.perdedor = PersonagemDTO.converterPersonagemParaDTO(perdedor);
		this.vencedorHabilidadeValor = vencedorHabilidadeValor;
		this.perdedorHabilidadeValor = perdedorHabilidadeValor;
		this.habilidade = habilidade;
	}

	public IPersonagem getVencedor() {
		return PersonagemDTO.converterDTOParaPersonagem(EnumTiposPersonagens.COMUM, this.vencedor);
	}

	public IPersonagem getPerdedor() {
		return PersonagemDTO.converterDTOParaPersonagem(EnumTiposPersonagens.COMUM, this.perdedor);
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
