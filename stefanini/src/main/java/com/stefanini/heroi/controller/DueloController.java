package com.stefanini.heroi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	public ResponseEntity<List<PlacarDTO>> duelar() throws IOException {
		List<PlacarDTO> placares = partidaService.iniciarPartidasERetornarPlacar();
		try {
			return new ResponseEntity<List<PlacarDTO>>(placares,HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<List<PlacarDTO>>(new ArrayList<PlacarDTO>(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
