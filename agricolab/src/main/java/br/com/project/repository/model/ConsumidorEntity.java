package br.com.project.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "consumidores")
public class ConsumidorEntity implements Serializable {

    private static final long serialVersionUID = -7049957706738879274L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_consumidor", nullable=false)
    private Integer idConsumidor;

    @Column(name="tipo_consumidor", columnDefinition="VARCHAR", length = 2)
    private String tipoConsumidor;

    @Column(name="segmento_consumidorPJ",columnDefinition="VARCHAR", length = 200)
    private String segmentoConsumidorPJ;

    @Column(name="nome_consumidor", columnDefinition="VARCHAR", length = 200)
    private String nomeConsumidor;

    @Column(name="email_consumidor", columnDefinition="VARCHAR", length = 100)
    private String emailConsumidor;

    @Column(name="cnpj_consumidor", columnDefinition="VARCHAR", length = 14)
    private String cnpjConsumidor;

    @Column(name="cpf_consumidor", columnDefinition="VARCHAR", length = 11)
    private String cpfConsumidor;

    @Column(name="telefone_consumidor", columnDefinition="VARCHAR", length = 13)
    private String telefoneConsumidor;

    @Column(name="endereco_consumidor", columnDefinition="VARCHAR", length = 100)
    private String enderecoConsumidor;

    @Column(name="compl_end_consumidor", columnDefinition="VARCHAR", length = 40)
    private String complementoEnderecoconsumidor;

    @Column(name="lat_consumidor", columnDefinition="VARCHAR", length = 10)
    private String latitudeConsumidor;

    @Column(name="long_consumidor", columnDefinition="VARCHAR", length = 10)
    private String longitudeConsumidor;
    
}
