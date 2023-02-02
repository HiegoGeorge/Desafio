package com.example.testetecnico.service;

import com.example.testetecnico.entities.Pessoa;
import com.example.testetecnico.repository.EnderecoRepository;
import com.example.testetecnico.repository.PessoaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;


	public Pessoa salvarPessoa(Pessoa pessoa) {
//		enderecoRepository.save(pessoa.getEndereco());
		return this.pessoaRepository.save(pessoa);
	}

	
	public List<Pessoa> buscarAll(){
		List<Pessoa> list = pessoaRepository.findAll();
		return list;
	}
	
	
	public Pessoa update(Long id, Pessoa pessoa) {
		Pessoa pessoa2 = findById(id);
		pessoa2.setNome(pessoa.getNome());
		pessoa2.setDataNascimento(pessoa.getDataNascimento());
		return pessoaRepository.save(pessoa2);
	}
	
	public void delete(Long id) {
		pessoaRepository.deleteById(id);
	}

	
	public Pessoa findById(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		return pessoa.orElseThrow( ()-> new ObjectNotFoundException("Objeto não encontrado! id: " + id + ", Tipo: " + Pessoa.class.getName(), id.toString()));
	}

	public Optional<Pessoa> buscar(Long id) {
		return pessoaRepository.findById(id);
	}
}
