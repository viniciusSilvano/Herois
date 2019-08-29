package com.stefanini.heroi.model;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.stefanini.heroi.model.factory.IPersonagem;
import com.stefanini.heroi.util.EnumPersonagemSituacao;

/**
 * Classe que irá carregar todos os personagens
 * @author paulo
 *
 */
@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Personagem implements IPersonagem {

	private String nome;
	private String alinhamento;
	private EnumPersonagemSituacao situacao = EnumPersonagemSituacao.INDIFERENTE;
	private Integer inteligencia;
	private Integer forca;
	private Integer destreza;
	private Integer poder;
	private Integer combate;
	private Integer defesa;
	private Integer vitorias;
	
	public Personagem() {
		super();
	}
	
	public Personagem(String nome, String alinhamento, Integer inteligencia,
			Integer forca, Integer destreza, Integer poder, Integer combate, Integer defesa) {
		super();
		this.nome = nome;
		this.alinhamento = alinhamento;
		this.inteligencia = inteligencia;
		this.forca = forca;
		this.destreza = destreza;
		this.poder = poder;
		this.combate = combate;
		this.defesa = defesa;
	}
	
	public Integer getDefesa() {
		return defesa;
	}
	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAlinhamento() {
		return alinhamento;
	}
	public void setAlinhamento(String alinhamento) {
		this.alinhamento = alinhamento;
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
	
	public boolean isVencedor() {
		return this.situacao.equals(EnumPersonagemSituacao.VENCEDOR);
	}
	
	public EnumPersonagemSituacao getSituacao() {
		return situacao;
	}
	public void setSituacao(EnumPersonagemSituacao situacao) {
		this.situacao = situacao;
	}
	
	public Integer getVitorias() {
		return vitorias;
	}
	public void setVitorias(Integer vitorias) {
		this.vitorias = vitorias;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alinhamento == null) ? 0 : alinhamento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personagem other = (Personagem) obj;
		if (alinhamento == null) {
			if (other.alinhamento != null)
				return false;
		} else if (!alinhamento.equals(other.alinhamento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}	
}