package com.algaworks.algafoodapi.api.controller;

import com.algaworks.algafoodapi.api.model.CozinhasXmlWrapper;
import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@ResponseBody//Indica que a resposta dos metodos deve ser enviada como resposta da requisição HTTP
@RequestMapping("/cozinhas")//Posso adicionar o MediaType.APPLICATION_JSON_VALUE na classe toda. é só atribuir o (value = "/cozinha, produces = ")
public class CozinhaController {


    private CozinhaRepository cozinhaRepository;
    @Autowired
    public CozinhaController(CozinhaRepository cozinhaRepository) {
        this.cozinhaRepository = cozinhaRepository;
    }

    @GetMapping(/*produces = MediaType.APPLICATION_JSON_VALUE*/)//Faz o metodo só retornar em Json
    public List<Cozinha> listar() {
        return cozinhaRepository.listar();
    }
    //@ResponseStatus(HttpStatus.CREATED)//Altera o código do Status HTTP
    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id) throws Exception{ //Oo PathVariable é usado para mostrar qual Long id deve ser utilizado
        Cozinha cozinha = cozinhaRepository.buscar(id);
        if (cozinha != null) {
            return ResponseEntity.ok(cozinha);
        }

        //return ResponseEntity.status(HttpStatus.OK).body(cozinha);
        return ResponseEntity.notFound().build();

    }
    @PostMapping//Adicionar item na cozinha. O post serve pra Adicionar
    @ResponseStatus(HttpStatus.CREATED)//Altera o Status HTTP pra 201
    public Cozinha adicionar(@RequestBody Cozinha cozinha){
         return cozinhaRepository.salvar(cozinha);
    }
    @PutMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha){
        Cozinha cozinhaAtual = cozinhaRepository.buscar(cozinhaId);
        if(cozinhaAtual != null){
            //cozinhaAtual.setNome(cozinha.getNome()); Não é a melhor forma, já que se tivesse 10 atributos teria que fazer 10 setters
            BeanUtils.copyProperties(cozinha, cozinhaAtual, "id"); //Já esse metodo copia todas os atibutos de cozinha e joga em cozinhaAtual
            cozinhaAtual = cozinhaRepository.salvar(cozinhaAtual);
            return ResponseEntity.ok(cozinhaAtual);
        }
        return ResponseEntity.notFound().build();//Me retorna 404
    }
    @DeleteMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId){
        try {
            Cozinha cozinhaAtual = cozinhaRepository.buscar(cozinhaId);
            if(cozinhaAtual != null){
                cozinhaRepository.remover(cozinhaAtual);
                return ResponseEntity.noContent().build();// Fala que deu status ok mas não me retorna um corpo. Protocolo 204
            }
            return ResponseEntity.notFound().build();
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();//Isso é pra tratar a Violação dee Integridade do Banco de dados
        }



    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhasXmlWrapper listarxml(){
        return new CozinhasXmlWrapper(cozinhaRepository.listar());
    }
}
