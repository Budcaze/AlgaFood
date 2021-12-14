package com.algaworks.algafoodapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity//É uma entidade, ou seja, uma tabela
public class Restaurante {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( nullable = false)
    private String nome;
    @Column(name = "taxa_frete", nullable = false)//Faz não aceitar nulo
    private BigDecimal taxaFrete;
    @ManyToOne
    @JoinColumn(name = "cozinha_id", nullable = false)//Caso eu queira alterar o nome
    private Cozinha cozinha;
    @JsonIgnore
    @Embedded
    private Endereco endereco;
    @JsonIgnore
    @ManyToMany //Muitos Restaurantes para muitos formaPagamento
    @JoinTable(name = "restaurante_forma_pagamento", joinColumns = @JoinColumn(name = "restaurante_id"),
    inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
    private List<FormaPagamento> formaPagamentoList = new ArrayList<>();

}
/*
* joinColumns é o restaurante
* inverseJoinColumns é o formaPagamento
* */
