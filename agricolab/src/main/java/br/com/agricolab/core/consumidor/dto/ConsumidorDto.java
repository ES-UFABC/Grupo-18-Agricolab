package br.com.agricolab.core.consumidor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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

    @JsonProperty("tipoConsumidor")
    private String tipoConsumidor;

    @JsonProperty("latitudeConsumidor")
    private String latitudeConsumidor;

    @JsonProperty("longitudeConsumidor")
    private String longitudeConsumidor;

}
