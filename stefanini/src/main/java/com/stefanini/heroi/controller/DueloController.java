package com.stefanini.heroi.controller;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.heroi.dto.PlacarDTO;
import com.stefanini.heroi.service.PartidaService;

@RestController
public class DueloController {
	@Autowired
	PartidaService partidaService;
	
	@RequestMapping(value = "/duelar",method = RequestMethod.GET)
	public ResponseEntity<List<PlacarDTO>> duelar(HttpServletResponse response) throws IOException {
		List<PlacarDTO> placares = partidaService.iniciarPartidasERetornarPlacar();
		try {
			return new ResponseEntity<List<PlacarDTO>>(placares,HttpStatus.OK);
		}catch(NullPointerException e){
			response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}catch(NoSuchElementException e) {
			response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}catch(Exception e) {
			response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return null;
	}
}
