package com.algaworks.algafoodapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    //@JsonIgnore
    @JsonIgnoreProperties("hibernateLazyInitializer")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cozinha_id", nullable = false)//Caso eu queira alterar o nome
    private Cozinha cozinha;
    @JsonIgnore
    @Embedded
    private Endereco endereco;
    @JsonIgnore
    @CreationTimestamp //Quando a entidade for criada é pra atribuir a hora atual a ela
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataCadastro;
    @JsonIgnore
    @UpdateTimestamp//Quando a entidade for atualizada é pra atribuir a hora atual nele
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;
    @JsonIgnore
    @ManyToMany //Muitos Restaurantes para muitos formaPagamento
    @JoinTable(name = "restaurante_forma_pagamento", joinColumns = @JoinColumn(name = "restaurante_id"),
    inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
    private List<FormaPagamento> formaPagamentoList = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "restaurante")
    private List<Produto> produtoList = new ArrayList<>();

}
/*
* joinColumns é o restaurante
* inverseJoinColumns é o formaPagamento
* */
