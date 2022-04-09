package br.com.agricolab.repository.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "produtos")
public class ProdutosEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_produtos")
    private Integer idProduto;

    @Column(name="nome_produtos")
    private String nomeProduto;

    @Column(name="quantidade_produtos")
    private Integer quantidadeProduto;

    @Column(name="valor_produtos")
    private BigDecimal valorProduto;

}
