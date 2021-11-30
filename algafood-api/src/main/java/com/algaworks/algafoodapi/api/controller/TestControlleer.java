package com.algaworks.algafoodapi.api.controller;

import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teste")
public class TestControlleer {
    @Autowired
    private CozinhaRepository cozinhaRepository;
    @GetMapping("/cozinhas/por-nome")
    public List<Cozinha> cozinhasPorNome(@RequestParam("nome") String nome) { //O RequestParam utiliza a ideia de passar como parametro o nome na Requisição HTTP
        return cozinhaRepository.findBynome(nome); //Quando usa o findBy-Ai aqui coloca o nome que vc quer- o SpringDataJpa entende o metodo
    }
}
