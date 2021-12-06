package com.algaworks.algafoodapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean //Essa interface não pode ser implementada para fins de intanciação
public interface CustomJpaRepository<T,ID> extends JpaRepository<T, ID> {

    Optional<T> buscarPrimeiro();

}
