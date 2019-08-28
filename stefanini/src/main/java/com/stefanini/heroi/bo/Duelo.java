package com.stefanini.heroi.bo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanini.heroi.util.BancoMemoriaUtil;

@Component
public class Duelo {
	
	@Autowired
	BancoMemoriaUtil bancoMemoriaUtil;
	public void randomizarHerois() {
		try {
			System.out.println(bancoMemoriaUtil.carregaPersonagens());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
