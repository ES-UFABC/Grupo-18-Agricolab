package br.com.agricolab.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Produto {

    private String nomeProduto;
    private Long quantidadeProduto;
    private BigDecimal valorProduto;

}
