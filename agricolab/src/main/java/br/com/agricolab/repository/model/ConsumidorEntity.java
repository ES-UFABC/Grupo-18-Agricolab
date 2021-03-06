package br.com.agricolab.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "consumidores", uniqueConstraints={@UniqueConstraint(columnNames={"email_consumidor"})})
public class ConsumidorEntity implements Serializable {

    private static final long serialVersionUID = -7049957706738879274L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_consumidor", nullable=false)
    private Integer idConsumidor;

    @Column(name="tipo_consumidor",  length = 2)
    private String tipoConsumidor;

    @Column(name="segmento_consumidorPJ", length = 200)
    private String segmentoConsumidorPJ;

    @Column(name="nome_consumidor",  length = 200)
    private String nomeConsumidor;

    @Column(name="email_consumidor",  length = 100, unique = true)
    private String emailConsumidor;

    @Column(name="senha_consumidor",  length = 100)
    private String senhaConsumidor;

    @Column(name="cnpj_consumidor",  length = 14)
    private String cnpjConsumidor;

    @Column(name="cpf_consumidor",  length = 11)
    private String cpfConsumidor;

    @Column(name="telefone_consumidor",  length = 13)
    private String telefoneConsumidor;

    @Column(name="endereco_consumidor",  length = 100)
    private String enderecoConsumidor;

    @Column(name="compl_end_consumidor",  length = 40)
    private String complementoEnderecoConsumidor;

    @Column(name="lat_consumidor", scale = 8, precision = 10)
    private BigDecimal latitudeConsumidor;

    @Column(name="long_consumidor", scale = 8, precision = 10)
    private BigDecimal longitudeConsumidor;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name="pedidos_id", nullable = true)
    private List<PedidosEntity> pedidos = new ArrayList<>();

}
