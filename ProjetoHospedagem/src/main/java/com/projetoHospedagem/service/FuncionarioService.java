package com.projetoHospedagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.projetoHospedagem.entities.Funcionario;
import com.projetoHospedagem.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	private final FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService (FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public List<Funcionario> buscaTodosFuncionario(){
		return funcionarioRepository.findAll();
	}
	
	public Funcionario getFuncionarioById(Long codigo) {
		Optional <Funcionario> Funcionario = funcionarioRepository.findById(codigo);
		return Funcionario.orElse(null);
	}
	
	public Funcionario saveFuncionario (Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public Funcionario alteraFuncionario (Long codigo, Funcionario alteraFuncionario) {
		Optional <Funcionario> existeFuncionario = funcionarioRepository.findById(codigo);
		if(existeFuncionario.isPresent()) {
			alteraFuncionario.setCodigo(codigo);
			return funcionarioRepository.save(alteraFuncionario);
		}
		return null;
	}
	
	public boolean apagarFuncionario(Long codigo) {
		Optional <Funcionario> existeFuncionario = funcionarioRepository.findById(codigo);
		if(existeFuncionario.isPresent()) {
			funcionarioRepository.deleteById(codigo);
			return true;
		}
		return false;
	
	}
	}
