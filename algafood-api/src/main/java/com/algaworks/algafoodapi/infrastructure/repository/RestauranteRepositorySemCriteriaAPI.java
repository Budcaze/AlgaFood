//package com.algaworks.algafoodapi.infrastructure.repository;
//
//import com.algaworks.algafoodapi.domain.model.Restaurante;
//import com.algaworks.algafoodapi.domain.repository.RestauranteRepositoryQueries;
//import org.springframework.stereotype.Repository;
//import org.springframework.util.StringUtils;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import java.math.BigDecimal;
//import java.util.HashMap;
//import java.util.List;
//
//@Repository
//public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries /*No momento em que eu criei a classe com Impl no final, o SDJPA entende que ele implementa a interface*/{
//
//    @PersistenceContext
//    private EntityManager manager;
//
//    @Override
//    public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
//
//        var jpql = new StringBuilder();
//        jpql.append("from Restaurante where 0 = 0 ");
//
//        var parametros = new HashMap<String, Object>();
//
//        if(StringUtils.hasLength(nome)){ //hasLenght verifica se o lenght da string é > 0
//            jpql.append("and nome like :nome ");
//            parametros.put("nome","%" + nome + "%");
//        }
//
//        if(taxaFreteInicial != null){
//            jpql.append("and taxaFrete >= :taxaInicial ");
//            parametros.put("taxaInicial", taxaFreteInicial);
//        }
//        if(taxaFreteFinal != null){
//            jpql.append("and taxaFrete <= :taxaFinal ");
//            parametros.put("taxaFinal",taxaFreteFinal);
//        }
//
//
//        TypedQuery<Restaurante> query = manager
//                .createQuery(jpql.toString(), Restaurante.class);
//        parametros.forEach((chave, valor) -> query.setParameter(chave, valor));
//        return query.getResultList();
//
//    }
//}
