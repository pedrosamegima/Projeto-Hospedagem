package com.projetoHospedagem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoHospedagem.entities.Aposento;
import com.projetoHospedagem.service.AposentoService;

@RestController
@RequestMapping("/aposento")
public class AposentoController {

	private final AposentoService aposentoService;
	
	@Autowired
	public AposentoController (AposentoService aposentoService) {
		this.aposentoService = aposentoService;
	}
	@GetMapping("/{codigo}")
	public ResponseEntity<Aposento> getAposentoControlId(@PathVariable Long codigo){
		Aposento aposento = aposentoService.getAposentoById(codigo);
		if(aposento != null) {
			return ResponseEntity.ok(aposento);
		}
		else {
			return ResponseEntity.notFound().build();
		}

	}
	@GetMapping
	public ResponseEntity<List<Aposento>> buscaTodosAposentoControl(){
		List<Aposento> aposento = aposentoService.buscaTodosAposento();

		return ResponseEntity.ok(aposento);
	}

	@PostMapping("/")
	public ResponseEntity<Aposento> saveAposentoControl(@RequestBody Aposento aposento){
		Aposento saveAposento = aposentoService.saveAposento(aposento);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveAposento);
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Aposento> alteraAposentoControl(@PathVariable Long codigo, @RequestBody Aposento aposento){
		Aposento alteraAposento = aposentoService.alteraAposento(codigo, aposento);
		if(alteraAposento !=null) {
			return ResponseEntity.ok(aposento);
		}
		else {
			return ResponseEntity.notFound().build();
		}

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagarAposentoControl(@PathVariable Long codigo){
		boolean apagar = aposentoService.apagarAposento(codigo);
		if(apagar) {
			return ResponseEntity.ok().body("O aposento foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}
