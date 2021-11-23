package com.algaworks.algafoodapi.domain.service;

import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.model.Cidade;
import com.algaworks.algafoodapi.domain.model.Estado;
import com.algaworks.algafoodapi.domain.repository.CidadeRepository;
import com.algaworks.algafoodapi.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}
