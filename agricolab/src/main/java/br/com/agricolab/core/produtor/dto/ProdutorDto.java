package br.com.agricolab.core.produtor.dto;

import br.com.agricolab.domain.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutorDto implements Serializable {

    @JsonProperty("idProdutor")
    private String idProdutor;

    @JsonProperty("nomeProdutor")
    private String nomeProdutor;

    @JsonProperty("emailProdutor")
    private String emailProdutor;

    @JsonProperty("enderecoProdutor")
    private String enderecoProdutor;

    @JsonProperty("complementoEnderecoProdutor")
    private String complementoEnderecoProdutor;

    @JsonProperty("cnpjProdutor")
    private String cnpjProdutor;

    @JsonProperty("senhaProdutor")
    private String senhaProdutor;

    @JsonProperty("telefoneProdutor")
    private String telefoneProdutor;

    @JsonProperty("tipoProdutor")
    private String tipoProdutor;

    @JsonProperty("latitudeProdutor")
    private String latitudeProdutor;

    @JsonProperty("produtos")
    private List<Produto> produtos;

    @JsonProperty("longitudeProdutor")
    private String longitudeProdutor;

}
