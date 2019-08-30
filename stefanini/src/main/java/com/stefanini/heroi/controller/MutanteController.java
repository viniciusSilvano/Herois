package com.stefanini.heroi.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.heroi.dto.PersonagemDTO;
import com.stefanini.heroi.service.PersonagemService;

@RestController
public class MutanteController {
	
	@Autowired
	PersonagemService personagemService;
	
	@RequestMapping(value = "/mutante", method = RequestMethod.GET)
	public ResponseEntity<PersonagemDTO> getMutante(HttpServletResponse response) throws IOException {
		try {
			return new ResponseEntity<PersonagemDTO>(PersonagemDTO.converterMutanteParaDTO(personagemService.getMutante()),HttpStatus.OK);
		}catch(NullPointerException e) {
			response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}catch(Exception e) {
			response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return null;
	}
}
