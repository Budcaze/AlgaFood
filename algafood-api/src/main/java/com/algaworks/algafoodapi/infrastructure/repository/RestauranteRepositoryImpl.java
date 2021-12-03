package com.algaworks.algafoodapi.infrastructure.repository;

import com.algaworks.algafoodapi.domain.model.Restaurante;
import com.algaworks.algafoodapi.domain.repository.RestauranteRepositoryQueries;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery<Restaurante> criteriaQuery = builder.createQuery(Restaurante.class);
        Root<Restaurante> root = criteriaQuery.from(Restaurante.class);

        var predicares = new ArrayList<Predicate>();
        if(StringUtils.hasText(nome)){
            predicares.add(builder.like(root.get("nome"), "%" + nome + "%"));
        }
        if(taxaFreteInicial != null){
            predicares.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
        }
        if(taxaFreteFinal != null){
            predicares.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
        }

        criteriaQuery.where(predicares.toArray(new Predicate[0]));
        
        TypedQuery<Restaurante> query = manager.createQuery(criteriaQuery);
                 return query.getResultList();
    }
}
