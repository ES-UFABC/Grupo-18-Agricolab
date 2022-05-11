package br.com.agricolab.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Consumidor {

    private Integer id;

    private String tipoConsumidor;

    private String nomeConsumidor;

    private String emailConsumidor;

    private String senhaConsumidor;

    private String cnpjConsumidor;

    private String cpfConsumidor;

    private String telefoneConsumidor;

    private String enderecoConsumidor;

    private String complementoEnderecoConsumidor;

    private BigDecimal latitudeConsumidor;

    private List<Pedido> pedidos;

    private BigDecimal longitudeConsumidor;
}

