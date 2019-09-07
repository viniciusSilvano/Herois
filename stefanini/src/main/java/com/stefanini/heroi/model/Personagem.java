package com.stefanini.heroi.model;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.stefanini.heroi.model.factory.IPersonagem;
import com.stefanini.heroi.util.enuns.EnumPersonagemSituacao;

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
	private Integer vitorias = new Integer(0);
	
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
	@Override
	public Integer getDefesa() {
		return defesa;
	}
	@Override
	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}
	@Override
	public String getNome() {
		return nome;
	}
	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String getAlinhamento() {
		return alinhamento;
	}
	@Override
	public void setAlinhamento(String alinhamento) {
		this.alinhamento = alinhamento;
	}
	@Override
	public Integer getInteligencia() {
		return inteligencia;
	}
	@Override
	public void setInteligencia(Integer inteligencia) {
		this.inteligencia = inteligencia;
	}
	@Override
	public Integer getForca() {
		return forca;
	}
	@Override
	public void setForca(Integer forca) {
		this.forca = forca;
	}
	@Override
	public Integer getDestreza() {
		return destreza;
	}
	@Override
	public void setDestreza(Integer destreza) {
		this.destreza = destreza;
	}
	@Override
	public Integer getPoder() {
		return poder;
	}
	@Override
	public void setPoder(Integer poder) {
		this.poder = poder;
	}
	@Override
	public Integer getCombate() {
		return combate;
	}
	@Override
	public void setCombate(Integer combate) {
		this.combate = combate;
	}
	@Override
	public boolean isVencedor() {
		return this.situacao.equals(EnumPersonagemSituacao.VENCEDOR);
	}
	@Override
	public EnumPersonagemSituacao getSituacao() {
		return situacao;
	}
	@Override
	public void setSituacao(EnumPersonagemSituacao situacao) {
		this.situacao = situacao;
	}
	@Override
	public Integer getVitorias() {
		return vitorias;
	}
	@Override
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

	@Override
	public String toString() {
		return "Personagem [nome=" + nome + ", alinhamento=" + alinhamento + ", situacao=" + situacao
				+ ", inteligencia=" + inteligencia + ", forca=" + forca + ", destreza=" + destreza + ", poder=" + poder
				+ ", combate=" + combate + ", defesa=" + defesa + ", vitorias=" + vitorias + "]";
	}	
	
	
}