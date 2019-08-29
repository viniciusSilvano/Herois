package com.stefanini.heroi.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.stefanini.heroi.model.Personagem;

public class PersonagemUtil {
	
	//Variáveis final
	final String arquivo = "C:\\Users\\vinicius silvano\\Documents\\Projetos\\Stefanini\\stefaninimarveldc\\stefanini\\src\\main\\java\\com\\stefanini\\heroi\\db\\charcters_stats.csv";
	
	public PersonagemUtil(){
		
	}
	
	public List<Personagem> carregaCSV() throws IOException{
		List<Personagem> personagemDtos = new ArrayList<Personagem>();
		Reader reader = Files.newBufferedReader(Paths.get(arquivo));
		CSVReader leitor = new CSVReaderBuilder(reader).withSkipLines(1).build();
		List<String[]> csv = leitor.readAll();
		Integer count = 0;
		
		for (String[] linhas : csv){
			Personagem personagemDto = new Personagem();
	        for (String coluna : linhas){
	        	if(count == 0)
	        		personagemDto.setNome(coluna);
	        	if(count == 1)
	        		personagemDto.setAlinhamento(coluna);
	        	if(count == 2)
	        		personagemDto.setInteligencia(Integer.valueOf(coluna));
	        	if(count == 3)
	        		personagemDto.setForca(Integer.valueOf(coluna));
	        	if(count == 4)
	        		personagemDto.setDestreza(Integer.valueOf(coluna));
	        	if(count == 5)
	        		personagemDto.setDefesa(Integer.valueOf(coluna));
	        	if(count == 6)
	        		personagemDto.setPoder(Integer.valueOf(coluna));
	        	if(count == 7)
	        		personagemDto.setCombate(Integer.valueOf(coluna));
	        	
	        	count++;
	        	
	        	if(count == 8){
	        		personagemDtos.add(personagemDto);
	        		personagemDto = null;
	        		count = 0;
	        	}
	        }
		}
		
		leitor.close();
		
		return personagemDtos;
	}
	
	public static Personagem PersonagemComparator(Personagem personagem1, Personagem personagem2, int valor1, int valor2) {
		if(valor1 > valor2) {
			return personagem1;
		}else {
			return personagem2;
		}
	}
}