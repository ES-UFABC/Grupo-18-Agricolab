package br.com.agricolab.core.produtos.mapper;

import br.com.agricolab.domain.Pedido;
import br.com.agricolab.domain.Produto;
import br.com.agricolab.repository.model.PedidosEntity;
import br.com.agricolab.repository.model.ProdutosEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutosMapper {

    ProdutosEntity toProdutos(Produto produtos);

    PedidosEntity toPedidos(Pedido produtos);

}
