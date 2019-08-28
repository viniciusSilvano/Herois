package com.stefanini.heroi.util;

import java.util.Random;

public enum EnumPersonagemHabilidades {
	INTELIGENCIA,FORCA,DESTREZA, PODER, COMBATE,DEFESA;
	
	 public static EnumPersonagemHabilidades getRandomHabilidades(Random random) {
        return values()[random.nextInt(values().length)];
    }
}
