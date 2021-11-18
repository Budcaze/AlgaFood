package com.algaworks.algafoodapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
@JsonRootName("cozinha")//Altera o nome da classe quando for mostrada no postman. Obs, apenas XML
@Data//Get, set, equals e hashcode, contrutor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)//Usando os incluidos no equals
@Entity
public class Cozinha {
    @EqualsAndHashCode.Include//Equals apenas com id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Isso aqui fala que quem gera a chave é o provedor mysql
    private Long id;
    //@JsonIgnore//Basicamente quando for mostrar ela ignora esse atributo
    //@JsonProperty("titulo")//Altera o nome que será mostrado quando levantar a aplicacao. Obs: Ele tem prioridade sobre o JsonIgnore
    @Column(nullable = false)
    private String nome;

}
