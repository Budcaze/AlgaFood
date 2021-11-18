//package com.algaworks.algafoodapi.jpa;
//
//import com.algaworks.algafoodapi.AlgafoodApiApplication;
//import com.algaworks.algafoodapi.domain.model.Cozinha;
//import com.algaworks.algafoodapi.domain.repository.CozinhaRepository;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.context.ApplicationContext;
//
//public class AlteracaoCozinhaMain {
//
//    public static void main(String[] args) {
//
//        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
//                .web(WebApplicationType.NONE)
//                .run(args);
//       CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
//       Cozinha cozinha = new Cozinha();
//       cozinha.setId(1l);//Ele tá modificando a cozinha com id1 pra Japonesa
//       cozinha.setNome("Japonesa");
//       cozinhaRepository.salvar(cozinha);
//
//    }
//}
