//package com.algaworks.algafoodapi.jpa;
//
//import com.algaworks.algafoodapi.AlgafoodApiApplication;
//import com.algaworks.algafoodapi.domain.model.Cozinha;
//import com.algaworks.algafoodapi.domain.repository.CozinhaRepository;
//import org.springframework.context.ApplicationContext;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//
//import java.util.List;
//
//public class ConsultaCozinhaMain {
//
//    public static void main(String[] args) {
//
//        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
//                .web(WebApplicationType.NONE)
//                .run(args);
//       CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
//       List<Cozinha> cozinhas = cozinhaRepository.listar();
//
//       for(Cozinha c : cozinhas){
//           System.out.println(c.getNome());
//       }
//    }
//}
