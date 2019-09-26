package com.redfield.comercial.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.redfield.comercial.model.Oportunidade;
import com.redfield.comercial.repository.OportunidadeRepository;

@RestController
@RequestMapping("/oportunidades") //rota
public class OportunidadeController {
	
	@Autowired
	private OportunidadeRepository oportunidadeRepository;
	
	@GetMapping
	public List<Oportunidade> listar()
	{
		return oportunidadeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Oportunidade> getOportunidade(@PathVariable Long id)//indicando que o ID vem pela rota
	{
		Optional<Oportunidade> oportunidade = oportunidadeRepository.findById(id);
		if(!oportunidade.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oportunidade.get());
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Oportunidade adicionar(@Valid @RequestBody Oportunidade oportunidade)//esse obj. vem do corpo da requisição
	{
		Optional<Oportunidade> oportunidadeExistente = oportunidadeRepository
				.findByDescricaoAndNomeProspecto(oportunidade.getDescricao(), oportunidade.getNomeProspecto());
		
		if(oportunidadeExistente.isPresent())
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Já existe uma Oportunidade p/ esse Prospecto com a mesma descrição");
		}
		
		return oportunidadeRepository.save(oportunidade);
	}
}













