package com.projetoHospedagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoHospedagem.entities.Aposento;
import com.projetoHospedagem.repository.AposentoRepository;

@Service
public class AposentoService {
	private final AposentoRepository aposentoRepository;
	
	@Autowired
	public AposentoService (AposentoRepository aposentoRepository) {
		this.aposentoRepository = aposentoRepository;
	}

	public List<Aposento> buscaTodosAposento(){
		return aposentoRepository.findAll();
	}
	
	public Aposento getAposentoById(Long codigo) {
		Optional <Aposento> Aposento = aposentoRepository.findById(codigo);
		return Aposento.orElse(null);
	}
	
	public Aposento saveAposento (Aposento aposento) {
		return aposentoRepository.save(aposento);
	}
	
	public Aposento alteraAposento (Long codigo, Aposento alteraAposento) {
		Optional <Aposento> existeAposento = aposentoRepository.findById(codigo);
		if(existeAposento.isPresent()) {
			alteraAposento.setCodigo(codigo);
			return aposentoRepository.save(alteraAposento);
		}
		return null;
	}
	
	public boolean apagarAposento(Long codigo) {
		Optional <Aposento> existeAposento = aposentoRepository.findById(codigo);
		if(existeAposento.isPresent()) {
			aposentoRepository.deleteById(codigo);
			return true;
		}
		return false;
	
	}

}
