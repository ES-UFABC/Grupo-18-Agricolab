package br.com.agricolab.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "produtores", uniqueConstraints={@UniqueConstraint(columnNames={"email_produtor"})})
public class ProdutorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_produtor", nullable=false)
    private Integer idProdutor;

    @Column(name="nome_produtor",  length = 200)
    private String nomeProdutor;

    @Column(name="tipo_produtor",  length = 2)
    private String tipoProdutor;

    @Column(name="email_produtor",  length = 100, unique = true)
    private String emailProdutor;

    @Column(name="senha_produtor",  length = 100)
    private String senhaProdutor;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name="pedidos_recebidos_id")
    private List<PedidosEntity> pedidosRecebidos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name="produtor_id", nullable = true)
    private List<ProdutosEntity> produtos = new ArrayList<>();

    @Column(name="cnpj_produtor",  length = 14)
    private String cnpjProdutor;

    @Column(name="cpf_produtor",  length = 11)
    private String cpfProdutor;

    @Column(name="telefone_produtor",  length = 13)
    private String telefoneProdutor;

    @Column(name="endereco_produtor",  length = 100)
    private String enderecoProdutor;

    @Column(name="compl_end_produtor",  length = 40)
    private String complementoEnderecoProdutor;

    @Column(name="lat_produtor", scale = 8, precision = 10)
    private BigDecimal latitudeProdutor;

    @Column(name="long_produtor", scale = 8, precision = 10)
    private BigDecimal longitudeProdutor;
}
