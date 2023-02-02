package com.example.testetecnico.rest;

import com.example.testetecnico.entities.Pessoa;
import com.example.testetecnico.service.PessoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class PessoaResource {
	private static final Logger log = LoggerFactory.getLogger(PessoaResource.class);


	@Autowired
	private final PessoaService pessoaService;

	public PessoaResource(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}


	//Criar endereço para pessoa
	@PostMapping("/pessoa")
	public ResponseEntity<Pessoa> salvarPessoa(@Valid @RequestBody Pessoa pessoa) throws URISyntaxException	{
		pessoa = pessoaService.salvarPessoa(pessoa);
		return ResponseEntity.created(new URI("/pessoa/" + pessoa.getId())).body(pessoa);
	}


	//Listar pessoas
	@GetMapping("/pessoa")
	public ResponseEntity<List<Pessoa>> getAllPessoa(){
		return  ResponseEntity.ok(pessoaService.buscarAll());
	}

	//Consultar uma pessoa
	@GetMapping("/pessoa/{id}")
	public ResponseEntity<Optional<Pessoa>> getPessoa(@PathVariable Long id){
		return  ResponseEntity.ok(pessoaService.buscar(id));
	}
	
	//Editar uma pessoa
	@PutMapping("/pessoa/{id}")
	public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody Pessoa Pessoa)
	{
		if(Pessoa.getId() == null) {
			log.error("Erro ao realizar update id esta nulo!");
		}
		
		Pessoa result = pessoaService.update(id, Pessoa);
		
		return ResponseEntity.ok().body(result);
	}

	//Deletar uma pessoa
	@DeleteMapping("/pessoa/{id}")
	public ResponseEntity<Void> deletePessoa(@PathVariable Long id){
		pessoaService.delete(id);
		return ResponseEntity.noContent().build();
	}
		

	
}
