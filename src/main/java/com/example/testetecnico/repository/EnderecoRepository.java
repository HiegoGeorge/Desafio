package com.example.testetecnico.repository;

import com.example.testetecnico.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query( nativeQuery = true, value =
            "select \n" +
                        "e.id, \n" +
                        "p.nome, \n" +
                        "e.logradouro, \n" +
                        "e.cep, \n" +
                        "e.numero, \n" +
                        "e.nome_cidade \n" +
                    " from endereco e \n" +
                    " join pessoa p on (p.id = e.pessoa_id) " +
                  " where e.pessoa_id = :pessoa_id \n")
    Optional<Endereco> buscarEnderecoPorPessoa(@Param("pessoa_id") Long idPessoa);


}
