package com.algaworks.algafoodapi.api.model;

import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NonNull;

import java.util.List;
@JacksonXmlRootElement(localName = "cozinhas")
@Data
public class CozinhasXmlWrapper {
    @JsonProperty("cozinhas")
    @JacksonXmlElementWrapper(useWrapping = false)
    @NonNull//Serve para o loombok instanciar o contrutor com uma varivel que não seria obrigatoria
    private List<Cozinha> cozinha;
}
