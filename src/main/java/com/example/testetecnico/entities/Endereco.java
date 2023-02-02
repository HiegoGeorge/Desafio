package com.example.testetecnico.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name= "endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "logradouro", nullable = false)
	private String logradouro;

	@Column(name = "cep", nullable = false)
	private String cep;

	@Column(name = "numero", nullable = false)
	private Integer numero;

	@Column(name = "nome_cidade", nullable = false)
	private String nomeCidade;

//	@ManyToOne
//	@JoinColumn(name = "pessoa_id" )//chave estrangeira da tabela pessoa
//	private Pessoa pessoa;


	@Column(name = "pessoa_id", nullable = false)
	private Long pessoaId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public Long getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}
}
