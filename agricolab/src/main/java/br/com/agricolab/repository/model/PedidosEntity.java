package br.com.agricolab.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "pedidos")
public class PedidosEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_pedidos")
    private Integer idPedido;

    @Column(name="nome_pedidos")
    private String nomePedido;

    @Column(name="quantidade_pedidos")
    private Integer quantidadePedido;

    @Column(name="valor_pedidos")
    private BigDecimal valorPedido;

}

