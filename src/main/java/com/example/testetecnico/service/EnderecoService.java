package com.example.testetecnico.service;

import com.example.testetecnico.entities.Endereco;
import com.example.testetecnico.entities.Pessoa;
import com.example.testetecnico.repository.EnderecoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	

	public Endereco salvarEndereco(Endereco endereco) {
		return this.enderecoRepository.save(endereco);
	}

	public List<Endereco> buscarAll() {
		List<Endereco> list = enderecoRepository.findAll();
		return list;
	}


    public Object buscarEnderecoPorPessoa(Long idPessoa) {
		return enderecoRepository.buscarEnderecoPorPessoa(idPessoa);
    }
}
