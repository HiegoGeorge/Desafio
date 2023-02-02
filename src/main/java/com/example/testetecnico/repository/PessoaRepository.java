package com.example.testetecnico.repository;

import com.example.testetecnico.entities.Endereco;
import com.example.testetecnico.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

//    @Modifying
//    @Query(" insert into tb_pessoa( " +
//            " nome,\n " +
//            " data_nascimento\n )" +
//            "values( \n" +
//            " nome = :nome,\n" +
//            " data_nascimento = :data_nascimento\n")
//    Pessoa salvarPessoa(@Param("nome") String nome,
//                      @Param("data_nascimento") String dataNascimento);


}
