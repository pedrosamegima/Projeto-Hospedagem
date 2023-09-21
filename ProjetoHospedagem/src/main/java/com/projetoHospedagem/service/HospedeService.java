package com.projetoHospedagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoHospedagem.entities.Hospede;
import com.projetoHospedagem.repository.HospedeRepository;

@Service
public class HospedeService {
		private final HospedeRepository hospedeRepository;

		@Autowired
		public HospedeService (HospedeRepository hospedeRepository) {
			this.hospedeRepository = hospedeRepository;
		}

		public List<Hospede> buscaTodosHospede(){
			return hospedeRepository.findAll();
		}
		
		public  Hospede getFuncionarioById(Long codigo) {
			Optional <Hospede> Hospede = hospedeRepository.findById(codigo);
			return Hospede.orElse(null);
		}
		
		public  Hospede saveHospede (Hospede hospede) {
			return hospedeRepository.save(hospede);
		}
		
		public Hospede alteraHospede (Long codigo, Hospede alteraHospede) {
			Optional <Hospede> existeHospede = hospedeRepository.findById(codigo);
			if(existeHospede.isPresent()) {
				alteraHospede.setCodigo(codigo);
				return hospedeRepository.save(alteraHospede);
			}
			return null;
		}
		
		public boolean apagarHospede(Long codigo) {
			Optional <Hospede> existeHospede = hospedeRepository.findById(codigo);
			if(existeHospede.isPresent()) {
				hospedeRepository.deleteById(codigo);
				return true;
			}
			return false;
		
		}

}
