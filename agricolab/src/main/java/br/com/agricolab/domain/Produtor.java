package br.com.agricolab.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Produtor {

    private Integer id;

    private String nomeProdutor;

    private String emailProdutor;

    private String senhaProdutor;

    private String cnpjProdutor;

    private String cpfProdutor;

    private String telefoneProdutor;

    private String complementoEnderecoProdutor;

    private String enderecoProdutor;

    private String tipoProdutor;

    private BigDecimal latitudeProdutor;

    private BigDecimal longitudeProdutor;

    private List<Produto> produtos;
}
