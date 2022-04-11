package br.com.agricolab.service;

import br.com.agricolab.domain.Produto;
import br.com.agricolab.core.produtos.mapper.ProdutosMapper;
import br.com.agricolab.repository.adapter.ProdutoRepository;
import br.com.agricolab.repository.adapter.ProdutorRepository;
import br.com.agricolab.repository.model.ProdutorEntity;
import br.com.agricolab.repository.model.ProdutosEntity;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutorService {

    private final ProdutosMapper mapper = Mappers.getMapper(ProdutosMapper.class);



    @Autowired
    ProdutorRepository produtorRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutorEntity cadastro(Integer id, Produto produtos) {

        ProdutorEntity produtorEntity = produtorRepository.findByIdProdutor(id);

        ProdutosEntity produtosConverter = mapper.toProdutos(produtos);
        produtoRepository.save(produtosConverter);

        produtorEntity.getProdutos().add(produtosConverter);

        return produtorRepository.save(produtorEntity);


    }

    public void delete(Integer id) {
        ProdutosEntity produtosEntity = produtoRepository.findByIdProduto(id);

        produtoRepository.deleteById(produtosEntity.getIdProduto());

    }

    public void replace(Produto produtoNovo, Integer id) {

            ProdutosEntity produto = produtoRepository.findByIdProduto(id);

            produto.setNomeProduto(produtoNovo.getNomeProduto());
            produto.setValorProduto(produtoNovo.getValorProduto());
            produto.setQuantidadeProduto(produtoNovo.getQuantidadeProduto());

            produtoRepository.save(produto);

    }
}
