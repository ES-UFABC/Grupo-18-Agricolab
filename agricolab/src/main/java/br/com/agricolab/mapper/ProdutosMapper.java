package br.com.agricolab.mapper;


import br.com.agricolab.domain.Produto;
import br.com.agricolab.repository.model.ProdutorEntity;
import br.com.agricolab.repository.model.ProdutosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutosMapper {


    ProdutosEntity toProdutos(Produto produtos);

}
