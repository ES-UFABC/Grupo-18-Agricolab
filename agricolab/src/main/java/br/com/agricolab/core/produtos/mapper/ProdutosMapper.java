package br.com.agricolab.core.produtos.mapper;


import br.com.agricolab.domain.Produto;
import br.com.agricolab.repository.model.PedidosEntity;
import br.com.agricolab.repository.model.ProdutosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutosMapper {


    ProdutosEntity toProdutos(Produto produtos);

    @Mapping(target = "nomePedido", source ="nomeProduto")
    @Mapping(target = "quantidadePedido", source ="quantidadeProduto")
    @Mapping(target = "valorPedido", source ="valorProduto")
    PedidosEntity toPedidos(Produto produtos);

}
