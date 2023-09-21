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

import com.projetoHospedagem.entities.Funcionario;
import com.projetoHospedagem.service.FuncionarioService;



@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	private final FuncionarioService funcionarioService;
	
	@Autowired
	public FuncionarioController (FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	@GetMapping("/{codigo}")
	public ResponseEntity<Funcionario> getFuncionarioControlId(@PathVariable Long codigo){
		Funcionario funcionario = funcionarioService.getFuncionarioById(codigo);
		if(funcionario != null) {
			return ResponseEntity.ok(funcionario);
	}
		else {
			return ResponseEntity.notFound().build();
		}

	}
	@GetMapping
	public ResponseEntity<List<Funcionario>> buscaTodosFuncionarioControl(){
		List<Funcionario> funcionario = funcionarioService.buscaTodosFuncionario();

		return ResponseEntity.ok(funcionario);
	}
	
	@PostMapping("/")
	public ResponseEntity<Funcionario> saveFuncionarioControl(@RequestBody Funcionario funcionario){
		Funcionario saveFuncionario = funcionarioService.saveFuncionario(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveFuncionario);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> alteraFuncionarioControl(@PathVariable Long codigo, @RequestBody Funcionario funcionario){
		Funcionario alteraFuncionario = funcionarioService.alteraFuncionario(codigo, funcionario);
		if(alteraFuncionario !=null) {
			return ResponseEntity.ok(funcionario);
		}
		else {
			return ResponseEntity.notFound().build();
		}

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagarFuncionarioControl(@PathVariable Long codigo){
		boolean apagar = funcionarioService.apagarFuncionario(codigo);
		if(apagar) {
			return ResponseEntity.ok().body("O funcionario foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
