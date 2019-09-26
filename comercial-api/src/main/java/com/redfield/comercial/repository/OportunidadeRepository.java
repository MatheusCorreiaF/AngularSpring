package com.redfield.comercial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redfield.comercial.model.Oportunidade;

	//extende JPARepository, passando o Model e o tipo do ID do model
	public interface OportunidadeRepository extends JpaRepository<Oportunidade	, Long>
	{
		
		Optional<Oportunidade> findByDescricaoAndNomeProspecto(String descricao, String nomeProspecto);
		
	}
