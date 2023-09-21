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

import com.projetoHospedagem.entities.Hospede;
import com.projetoHospedagem.service.HospedeService;

@RestController
@RequestMapping("/hospede")
public class HospedeController {
	private final HospedeService hospedeService;

	@Autowired
	public HospedeController (HospedeService hospedeService) {
		this.hospedeService = hospedeService;
	}
	@GetMapping("/{codigo}")
	public ResponseEntity<Hospede> getHospedeControlId(@PathVariable Long codigo){
		Hospede hospede = hospedeService.getFuncionarioById(codigo);
		if(hospede != null) {
			return ResponseEntity.ok(hospede);
		}
		else {
			return ResponseEntity.notFound().build();
		}

	}
	@GetMapping
	public ResponseEntity<List<Hospede>> buscaTodosHospedeControl(){
		List<Hospede> hospede = hospedeService.buscaTodosHospede();

		return ResponseEntity.ok(hospede);
	}

	@PostMapping("/")
	public ResponseEntity<Hospede> saveHospedeControl(@RequestBody Hospede hospede){
		Hospede saveHospede = hospedeService.saveHospede(hospede);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveHospede);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Hospede> alteraHospedeControl(@PathVariable Long codigo, @RequestBody Hospede hospede){
		Hospede alteraHospede = hospedeService.alteraHospede(codigo, hospede);
		if(alteraHospede !=null) {
			return ResponseEntity.ok(hospede);
		}
		else {
			return ResponseEntity.notFound().build();
		}

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagarHospedeControl(@PathVariable Long codigo){
		boolean apagar = hospedeService.apagarHospede(codigo);
		if(apagar) {
			return ResponseEntity.ok().body("O Hospede foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}

