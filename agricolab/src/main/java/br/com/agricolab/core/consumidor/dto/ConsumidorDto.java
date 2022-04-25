package br.com.agricolab.core.consumidor.dto;

import br.com.agricolab.domain.Pedido;
import br.com.agricolab.domain.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ConsumidorDto implements Serializable {

    @JsonProperty("idConsumidor")
    private String idConsumidor;

    @JsonProperty("nomeConsumidor")
    private String nomeConsumidor;

    @JsonProperty("emailConsumidor")
    private String emailConsumidor;

    @JsonProperty("enderecoConsumidor")
    private String enderecoConsumidor;

    @JsonProperty("complementoEnderecoConsumidor")
    private String complementoEnderecoConsumidor;

    @JsonProperty("cnpjConsumidor")
    private String cnpjConsumidor;

    @JsonProperty("senhaConsumidor")
    private String senhaConsumidor;

    @JsonProperty("telefoneConsumidor")
    private String telefoneConsumidor;

    @JsonProperty("pedidosConsumidor")
    private List<Pedido> pedidos;

    @JsonProperty("tipoConsumidor")
    private String tipoConsumidor;

    @JsonProperty("latitudeConsumidor")
    private BigDecimal latitudeConsumidor;

    @JsonProperty("longitudeConsumidor")
    private BigDecimal longitudeConsumidor;

}
