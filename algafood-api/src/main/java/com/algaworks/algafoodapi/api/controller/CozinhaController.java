package com.algaworks.algafoodapi.api.controller;

import com.algaworks.algafoodapi.api.model.CozinhasXmlWrapper;
import com.algaworks.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import com.algaworks.algafoodapi.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody//Indica que a resposta dos metodos deve ser enviada como resposta da requisição HTTP
@RequestMapping("/cozinhas")//Posso adicionar o MediaType.APPLICATION_JSON_VALUE na classe toda. é só atribuir o (value = "/cozinha, produces = ")
public class CozinhaController {

    private CadastroCozinhaService cadastroCozinha;
    private CozinhaRepository cozinhaRepository;
    @Autowired
    public CozinhaController(CozinhaRepository cozinhaRepository, CadastroCozinhaService cadastroCozinha) {
        this.cozinhaRepository = cozinhaRepository;
        this.cadastroCozinha = cadastroCozinha;
    }

    @GetMapping(/*produces = MediaType.APPLICATION_JSON_VALUE*/)//Faz o metodo só retornar em Json
    public List<Cozinha> listar() {
        return cozinhaRepository.findAll();
    }
    //@ResponseStatus(HttpStatus.CREATED)//Altera o código do Status HTTP
    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id) throws Exception{ //Oo PathVariable é usado para mostrar qual Long id deve ser utilizado
        Optional<Cozinha> cozinha = cozinhaRepository.findById(id);
        if (cozinha.isPresent()) {
            return ResponseEntity.ok(cozinha.get());
        }

        //return ResponseEntity.status(HttpStatus.OK).body(cozinha);
        return ResponseEntity.notFound().build();

    }
    @PostMapping//Adicionar item na cozinha. O post serve pra Adicionar
    @ResponseStatus(HttpStatus.CREATED)//Altera o Status HTTP pra 201
    public Cozinha adicionar(@RequestBody Cozinha cozinha){
         return cadastroCozinha.salvar(cozinha);
    }
    @PutMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha){
        Optional<Cozinha> cozinhaAtual = cozinhaRepository.findById(cozinhaId);
        if(cozinhaAtual.isPresent()){
            //cozinhaAtual.setNome(cozinha.getNome()); Não é a melhor forma, já que se tivesse 10 atributos teria que fazer 10 setters
            BeanUtils.copyProperties(cozinha, cozinhaAtual.get(), "id"); //Já esse metodo copia todas os atibutos de cozinha e joga em cozinhaAtual
             Cozinha cozinhaSalva = cadastroCozinha.salvar(cozinhaAtual.get());
            return ResponseEntity.ok(cozinhaSalva);
        }
        return ResponseEntity.notFound().build();//Me retorna 404
    }
    @DeleteMapping("/{cozinhaId}")
    public ResponseEntity<?> remover(@PathVariable Long cozinhaId){
        try {
            cadastroCozinha.excluir(cozinhaId);
            return ResponseEntity.noContent().build();

        }catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();//Significa que ele não achou a cozinha pra remover

        }catch (EntidadeEmUsoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }

    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhasXmlWrapper listarxml(){
        return new CozinhasXmlWrapper(cozinhaRepository.findAll());
    }
}
