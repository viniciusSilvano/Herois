package com.stefanini.heroi.bo;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.stefanini.heroi.util.BancoMemoriaUtil;

@Component
public class Duelo {
	
	BancoMemoriaUtil bancoMemoriaUtil = BancoMemoriaUtil.getInstance();
	
	public void randomizarHerois() {
		try {
			System.out.println(bancoMemoriaUtil.carregaPersonagens().get(0).getNome());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
