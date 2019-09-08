package com.stefanini.heroi.bo.partida;

import com.stefanini.heroi.model.factory.IPersonagem;

public abstract class Mutante implements IPersonagem {
	
	private Mutante() {
		
	}
	
	private static IPersonagem mutante;
	
	public static IPersonagem getMutante() {
		return mutante;
	}

	public static void setMutante(IPersonagem iPersonagem) {
		Mutante.mutante = iPersonagem;
	}
}
