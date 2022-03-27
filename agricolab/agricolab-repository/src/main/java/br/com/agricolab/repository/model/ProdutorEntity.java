package br.com.agricolab.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "produtores")
public class ProdutorEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_produtor", nullable=false)
    private Integer idProdutor;

    @Column(name="nome_produtor", columnDefinition="VARCHAR", length = 200)
    private String nomeProdutor;

    @Column(name="tipo_produtor", columnDefinition="VARCHAR", length = 2)
    private String tipoProdutor;

    @Column(name="email_produtor", columnDefinition="VARCHAR", length = 100)
    private String emailProdutor;

    @Column(name="cnpj_produtor", columnDefinition="VARCHAR", length = 14)
    private String cnpjProdutor;

    @Column(name="cpf_produtor", columnDefinition="VARCHAR", length = 11)
    private String cpfProdutor;

    @Column(name="telefone_produtor", columnDefinition="VARCHAR", length = 13)
    private String telefoneProdutor;

    @Column(name="endereco_produtor", columnDefinition="VARCHAR", length = 100)
    private String enderecoProdutor;

    @Column(name="compl_end_produtor", columnDefinition="VARCHAR", length = 40)
    private String complementoEnderecoProdutor;

    @Column(name="lat_produtor", columnDefinition="VARCHAR", length = 10)
    private String latitudeProdutor;

    @Column(name="long_produtor", columnDefinition="VARCHAR", length = 10)
    private String longitudeProdutor;



}
