package br.com.agricolab.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pedido {

    private String nomePedido;
    private Integer quantidadePedido;
    private BigDecimal valorPedido;

}
