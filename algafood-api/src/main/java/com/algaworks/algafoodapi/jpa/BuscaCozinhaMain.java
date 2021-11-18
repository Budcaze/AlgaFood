//package com.algaworks.algafoodapi.jpa;
//
//import com.algaworks.algafoodapi.AlgafoodApiApplication;
//import com.algaworks.algafoodapi.domain.model.Cozinha;
//import com.algaworks.algafoodapi.domain.repository.CozinhaRepository;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.context.ApplicationContext;
//
//public class BuscaCozinhaMain {
//
//    public static void main(String[] args) {
//
//        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
//                .web(WebApplicationType.NONE)
//                .run(args);
//       CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
//       Cozinha cozinhas = cozinhaRepository.buscar(1l);
//
//        System.out.println(cozinhas.getNome());
//    }
//}
