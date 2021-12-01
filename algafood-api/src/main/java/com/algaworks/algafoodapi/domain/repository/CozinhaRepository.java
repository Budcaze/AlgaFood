package com.algaworks.algafoodapi.domain.repository;

import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> { //JpaRepository é uma interface com muitos metodos prontos

    List<Cozinha> findBynome(String nome);//Quando usa o findBy-Ai aqui coloca o nome que vc quer- o SpringDataJpa entende o metodo
    boolean existsByNome(String nome);

}
/*
 * Para saber qual usar no findBy é só olhar a documentação do SpringDataJpa: Keywords de query methods
 * */