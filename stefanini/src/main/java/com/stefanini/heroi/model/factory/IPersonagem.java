package com.stefanini.heroi.model.factory;

import com.stefanini.heroi.util.enuns.EnumPersonagemSituacao;

public interface IPersonagem {
	
	String getNome();
	
	void setNome(String string);

	Integer getCombate();
	
	void setCombate(Integer combate);

	Integer getDefesa();
	
	void setDefesa(Integer defesa);

	Integer getDestreza();
	
	void setDestreza(Integer destreza);

	Integer getForca();

	void setForca(Integer forca);
	
	Integer getInteligencia();
	
	void setInteligencia(Integer inteligencia);

	Integer getPoder();

	void setPoder(Integer poder);

	Integer getVitorias();
	
	void setVitorias(Integer vitorias);
	
	String getAlinhamento();
	
	void setAlinhamento(String alinhamento);

	boolean isVencedor();

	EnumPersonagemSituacao getSituacao();
	
	void setSituacao(EnumPersonagemSituacao situacao);
	
	
	

}
