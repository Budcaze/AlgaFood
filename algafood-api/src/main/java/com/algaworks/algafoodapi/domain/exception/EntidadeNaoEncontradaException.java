package com.algaworks.algafoodapi.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{
    private static final long serialVersionUID = 1l;

    public EntidadeNaoEncontradaException(String msg){
        super(msg);
    }
}
