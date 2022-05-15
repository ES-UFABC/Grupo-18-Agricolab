package br.com.agricolab.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Produto {

    private String nomeProduto;
    private Integer quantidadeProduto;
    private BigDecimal valorProduto;

}
