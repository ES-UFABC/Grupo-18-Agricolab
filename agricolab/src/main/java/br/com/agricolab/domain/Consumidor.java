package br.com.agricolab.domain;

import lombok.Getter;
import lombok.Setter;

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

    private String EnderecoConsumidor;

    private String complementoEnderecoConsumidor;

    private String latitudeConsumidor;

    private List<Pedido> pedidos;

    private String longitudeConsumidor;
}

