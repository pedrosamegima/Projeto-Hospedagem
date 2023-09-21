package com.projetoHospedagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoHospedagem.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Long>{

}
