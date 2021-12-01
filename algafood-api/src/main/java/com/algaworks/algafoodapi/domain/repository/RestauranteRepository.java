package com.algaworks.algafoodapi.domain.repository;


import com.algaworks.algafoodapi.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

        List<Restaurante> findByTaxaFreteBetween(BigDecimal taxainicial, BigDecimal taxafinal);
        Optional<Restaurante> findFirstByNomeContaining(String nome);
        List<Restaurante> findTop2ByNomeContaining(String nome);
        int countByCozinhaId(Long cozinha);

//    List<Restaurante> listar();
//    Restaurante buscar(Long id);
//    Restaurante salvar(Restaurante restaurante);
//    void remover(Long id);
}
/*
* Para saber qual usar no findBy é só olhar a documentação do SpringDataJpa: Keywords de query methods
* */