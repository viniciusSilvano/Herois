package com.stefanini.heroi.util;

import java.util.Random;

import com.stefanini.heroi.model.Personagem;

public enum EnumPersonagemHabilidades implements IAtributo {
	INTELIGENCIA,FORCA,DESTREZA, PODER, COMBATE,DEFESA;
	
	 public static EnumPersonagemHabilidades getRandomHabilidades(Random random) {
        return values()[random.nextInt(values().length)];
    }

	@Override
	public void alterarAtributo(Personagem heroi1, Personagem heroi2, Personagem vencedor) {
		if(vencedor != null) {
			if(vencedor == heroi1) {
				heroi1.setPoder(heroi1.getPoder() + 2);
				heroi2.setPoder(heroi2.getPoder() - 2);
			}else {
				heroi1.setPoder(heroi1.getPoder() - 2);
				heroi2.setPoder(heroi2.getPoder() + 2);
			}
			System.out.println("Novo ponto do vencedor: " + vencedor.getNome() + " agora possui:" + vencedor.getPoder());
		}		
	}
}
