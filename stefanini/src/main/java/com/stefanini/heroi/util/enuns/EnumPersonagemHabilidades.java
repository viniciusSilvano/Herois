package com.stefanini.heroi.util.enuns;

import java.util.Random;

import com.stefanini.heroi.model.factory.IPersonagem;
import com.stefanini.heroi.util.IAtributo;

public enum EnumPersonagemHabilidades implements IAtributo {
	INTELIGENCIA{
		public void alterarAtributo(IPersonagem heroi1, IPersonagem heroi2, IPersonagem vencedor){
			if(vencedor != null) {
				if(vencedor == heroi1) {
					heroi1.setInteligencia(heroi1.getInteligencia() + 2);
					heroi2.setInteligencia(heroi2.getInteligencia() - 2);
					System.out.println();
				}else {
					heroi1.setInteligencia(heroi1.getInteligencia() - 2);
					heroi2.setInteligencia(heroi2.getInteligencia() + 2);
				}
				System.out.println("Novo ponto do vencedor: " + vencedor.getNome() + " agora possui:" + vencedor.getInteligencia());
			}
		}
	},
	FORCA{
		public void alterarAtributo(IPersonagem heroi1, IPersonagem heroi2, IPersonagem vencedor){
			if(vencedor != null) {
				if(vencedor == heroi1) {
					heroi1.setForca(heroi1.getForca() + 2);
					heroi2.setForca(heroi2.getForca() - 2);
				}else {
					heroi1.setForca(heroi1.getForca() - 2);
					heroi2.setForca(heroi2.getForca() + 2);
				}
				System.out.println("Novo ponto do vencedor: " + vencedor.getNome() + " agora possui:" + vencedor.getForca());
			}
		}
	},DESTREZA{
		public void alterarAtributo(IPersonagem heroi1, IPersonagem heroi2, IPersonagem vencedor){
			if(vencedor != null) {
				if(vencedor == heroi1) {
					heroi1.setDestreza(heroi1.getDestreza() + 2);
					heroi2.setDestreza(heroi2.getDestreza() - 2);
				}else {
					heroi1.setDestreza(heroi1.getDestreza() - 2);
					heroi2.setDestreza(heroi2.getDestreza() + 2);
				}
				System.out.println("Novo ponto do vencedor: " + vencedor.getNome() + " agora possui:" + vencedor.getDestreza());
			}
		}
	}, PODER{
		public void alterarAtributo(IPersonagem heroi1, IPersonagem heroi2, IPersonagem vencedor){
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
	}, COMBATE{
		public void alterarAtributo(IPersonagem heroi1, IPersonagem heroi2, IPersonagem vencedor){
			if(vencedor != null) {
				if(vencedor == heroi1) {
					heroi1.setCombate(heroi1.getCombate() + 2);
					heroi2.setCombate(heroi2.getCombate() - 2);
				}else {
					heroi1.setCombate(heroi1.getCombate() - 2);
					heroi2.setCombate(heroi2.getCombate() + 2);
				}
				System.out.println("Novo ponto do vencedor: " + vencedor.getNome() + " agora possui:" + vencedor.getCombate());
			}
		}
	},DEFESA{
		public void alterarAtributo(IPersonagem heroi1, IPersonagem heroi2, IPersonagem vencedor){
			if(vencedor != null) {
				if(vencedor == heroi1) {
					heroi1.setDefesa(heroi1.getDefesa() + 2);
					heroi2.setDefesa(heroi2.getDefesa() - 2);
				}else {
					heroi1.setDefesa(heroi1.getDefesa() - 2);
					heroi2.setDefesa(heroi2.getDefesa() + 2);
				}
				System.out.println("Novo ponto do vencedor: " + vencedor.getNome() + " agora possui:" + vencedor.getDefesa());
			}
		}
	};
	
	 public static EnumPersonagemHabilidades getRandomHabilidades(Random random) {
        return values()[random.nextInt(values().length)];
    }

}
