package com.algaworks.algafoodapi.domain.service;

import com.algaworks.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.model.Cidade;
import com.algaworks.algafoodapi.domain.model.Estado;
import com.algaworks.algafoodapi.domain.repository.CidadeRepository;
import com.algaworks.algafoodapi.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroEstadoService {
    private EstadoRepository estadoRepository;
    private CidadeRepository cidadeRepository;
    @Autowired
    public CadastroEstadoService(EstadoRepository estadoRepository, CidadeRepository cidadeRepository) {
        this.estadoRepository = estadoRepository;
        this.cidadeRepository = cidadeRepository;
    }

    public Estado salvar(Estado estado){
        Long cidadeId = estado.getCidade().getId();
        Cidade cidade = cidadeRepository.buscar(cidadeId);
        if(cidade != null){
            estado.setCidade(cidade);
            return estadoRepository.salvar(estado);
        }
        throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de cidade com código %d", cidadeId));
    }

    public void excluir(Long estadoId){
        try{
            estadoRepository.remover(estadoId);
        }catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro para estado com código: %d", estadoId));
        }catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(String.format("Estado com código %d não pode ser removido, pois está em uso", estadoId));
        }

    }

}
