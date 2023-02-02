package com.example.testetecnico.rest;

import com.example.testetecnico.entities.Pessoa;
import com.example.testetecnico.repository.PessoaRepository;
import com.example.testetecnico.service.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PessoaResourceTest extends AbstractTest{
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaResource pessoaResource;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private EntityManager em;
	
	private Pessoa pessoa;
	
	@BeforeEach
	public void setup() {

		pessoa = new Pessoa();
		pessoa.setId(1L);
		pessoa.setNome("Teste");
		pessoa.setDataNascimento("02-02-2023");
		pessoaRepository.save(pessoa);
	}
	
	@Test
	@Transactional
	public void getAllPessoa() throws Exception{
		this.mockMvc.perform(get("/pessoa"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.[*].id").isNotEmpty())
		.andExpect(jsonPath("$.[*].nome").value(pessoa.getNome()))
		.andExpect(jsonPath("$.[*].dataNascimento").value(pessoa.getDataNascimento()));

	}
	
	@Test
	@Transactional
	public void deletePessoa() throws Exception{
		//inicializa a base
		pessoaRepository.saveAndFlush(pessoa);
		
		int dataBaseSizeBeforeDelete = pessoaRepository.findAll().size();
		//realiza o delete
		this.mockMvc.perform(delete("/pessoa/{id}", pessoa.getId()))
		.andExpect(status().isNoContent());
		
		//valida se a base esta vazia
		List<Pessoa> list = pessoaRepository.findAll();
		assertThat(list).hasSize(dataBaseSizeBeforeDelete - 1);
		
	}


	@Test
	@Transactional
	public void criarPessoaSucesso() throws Exception{
		
		Pessoa pessoaAtual = pessoa;
		pessoaAtual.setNome("Algas marinhas");
		pessoaAtual.setDataNascimento("12-12-1997");
				
		String teste = super.mapToJson(pessoaAtual);

		this.mockMvc.perform(post("/pessoa")
		.contentType(MediaType.APPLICATION_JSON)
		.content(teste))
		.andExpect(status().isCreated());

	}
	

}
