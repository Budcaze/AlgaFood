package com.algaworks.algafoodapi.api.controller;

import com.algaworks.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.model.Cidade;
import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.repository.CidadeRepository;
import com.algaworks.algafoodapi.domain.service.CadastroCidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
    private CadastroCidadeService cadastroCidade;
    private CidadeRepository cidadeRepository;
    @Autowired
    public CidadeController(CadastroCidadeService cadastroCidade, CidadeRepository cidadeRepository) {
        this.cadastroCidade = cadastroCidade;
        this.cidadeRepository = cidadeRepository;
    }

    @GetMapping
    public List<Cidade> listar(){
        return cidadeRepository.findAll();
    }

    @GetMapping("/{cidadeId}")
    public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId){
        Optional<Cidade> cidade = cidadeRepository.findById(cidadeId);
        if(cidade.isPresent()){
            return ResponseEntity.ok(cidade.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping//Adicionar item na cozinha. O post serve pra Adicionar
    @ResponseStatus(HttpStatus.CREATED)//Altera o Status HTTP pra 201
    public Cidade adicionar(@RequestBody Cidade cidade){
        return cadastroCidade.salvar(cidade);
    }

    @PutMapping("/{cidadeId}")
    public ResponseEntity<Cidade> atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade){
        Optional<Cidade> cidadeAtual = cidadeRepository.findById(cidadeId);
        if(cidadeAtual.isPresent()){
            //cozinhaAtual.setNome(cozinha.getNome()); Não é a melhor forma, já que se tivesse 10 atributos teria que fazer 10 setters
            BeanUtils.copyProperties(cidade, cidadeAtual.get(), "id"); //Já esse metodo copia todas os atibutos de cozinha e joga em cozinhaAtual
           Cidade cidadeSalva = cadastroCidade.salvar(cidadeAtual.get());
            return ResponseEntity.ok(cidadeSalva);
        }
        return ResponseEntity.notFound().build();//Me retorna 404
    }
    @DeleteMapping("/{cidadeId}")
    public ResponseEntity<Cidade> remover(@PathVariable Long cidadeId){
        try {
            cadastroCidade.excluir(cidadeId);
            return ResponseEntity.noContent().build();

        }catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();//Significa que ele não achou a cozinha pra remover

        }catch (EntidadeEmUsoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }

}
