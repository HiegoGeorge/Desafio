package com.example.testetecnico.rest;

import com.example.testetecnico.entities.Endereco;
import com.example.testetecnico.service.EnderecoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class EnderecoResource {
    private static final Logger log = LoggerFactory.getLogger(EnderecoResource.class);


    @Autowired
    private final EnderecoService enderecoService;

    public EnderecoResource(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }


    //Criar endereço para pessoa
    @PostMapping("/endereco")
    public ResponseEntity<Endereco> salvarEndereco(@Valid @RequestBody Endereco endereco) throws URISyntaxException {
        endereco = enderecoService.salvarEndereco(endereco);
        return ResponseEntity.created(new URI("/pessoa/" + endereco.getId())).body(endereco);
    }

    //Listar endereços da pessoa
    @GetMapping("/endereco")
    public ResponseEntity<List<Endereco>> getAllPessoa(){
        return  ResponseEntity.ok(enderecoService.buscarAll());
    }

    @GetMapping("/endereco/{id}")
    public ResponseEntity<Object> getPessoa(@PathVariable Long idPessoa){
        return  ResponseEntity.ok(enderecoService.buscarEnderecoPorPessoa(idPessoa));
    }

}
