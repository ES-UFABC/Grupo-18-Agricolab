package br.com.agricolab.service;

import br.com.agricolab.domain.Produto;
import br.com.agricolab.mapper.ProdutosMapper;
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

    public ProdutorEntity cadastro(Integer id, Produto produtos) {

        ProdutorEntity produtorEntity = produtorRepository.findByIdProdutor(id);

        ProdutosEntity produtosConverter = mapper.toProdutos(produtos);

        produtorEntity.getProdutos().add(produtosConverter);

        return produtorRepository.save(produtorEntity);







    }
}
