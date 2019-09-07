package com.stefanini.heroi.dto;

import java.io.Serializable;

import com.stefanini.heroi.model.Personagem;
import com.stefanini.heroi.model.factory.EnumTiposPersonagens;
import com.stefanini.heroi.model.factory.IPersonagem;
import com.stefanini.heroi.model.factory.PersonagemFactory;

public class PersonagemDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3059294818014827592L;
	private String nome;
	private Integer inteligencia;
	private Integer forca;
	private Integer destreza;
	private Integer poder;
	private Integer combate;
	private Integer defesa;
	private String alinhamento;
	
	public PersonagemDTO() {
		
	}
	
	public PersonagemDTO(String nome,
		String alinhamento,
		Integer inteligencia,
		Integer forca,
		Integer destreza,
		Integer poder,
		Integer combate,
		Integer defesa
	){
		this.nome = nome;
		this.inteligencia = inteligencia;
		this.forca = forca;
		this.destreza = destreza;
		this.poder = poder;
		this.combate = combate;
		this.defesa = defesa;
		this.alinhamento = alinhamento;
	}
	
	public static PersonagemDTO converterPersonagemParaDTO(IPersonagem personagem) {
		return new PersonagemDTO(personagem.getNome(),
				personagem.getAlinhamento(),
				personagem.getInteligencia(),
				personagem.getForca(),
				personagem.getDestreza(),
				personagem.getPoder(),
				personagem.getCombate(),
				personagem.getDefesa());
	}
	
	public static IPersonagem converterDTOParaPersonagem(EnumTiposPersonagens tipo ,PersonagemDTO personagem) {
		try {
			return PersonagemFactory.getInstace().
					getObject(tipo,personagem.getNome(),personagem.getAlinhamento(),personagem.getInteligencia(), 
							personagem.getForca(),personagem.getDestreza(),personagem.getPoder(),
							personagem.getCombate(), personagem.getDefesa());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new IllegalStateException("Erro ao converter personagemDTO para Ipersonagem");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(Integer inteligencia) {
		this.inteligencia = inteligencia;
	}

	public Integer getForca() {
		return forca;
	}

	public void setForca(Integer forca) {
		this.forca = forca;
	}

	public Integer getDestreza() {
		return destreza;
	}

	public void setDestreza(Integer destreza) {
		this.destreza = destreza;
	}

	public Integer getPoder() {
		return poder;
	}

	public void setPoder(Integer poder) {
		this.poder = poder;
	}

	public Integer getCombate() {
		return combate;
	}

	public void setCombate(Integer combate) {
		this.combate = combate;
	}

	public Integer getDefesa() {
		return defesa;
	}

	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}

	private String getAlinhamento() {
		return alinhamento;
	}

	private void setAlinhamento(String alinhamento) {
		this.alinhamento = alinhamento;
	}
	
	
	
}

