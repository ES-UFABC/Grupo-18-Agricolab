package br.com.agricolab.service;

import br.com.agricolab.domain.Produto;
import br.com.agricolab.core.produtos.mapper.ProdutosMapper;
import br.com.agricolab.domain.Produtor;
import br.com.agricolab.repository.adapter.ProdutoRepository;
import br.com.agricolab.repository.adapter.ProdutorRepository;
import br.com.agricolab.repository.model.ConsumidorEntity;
import br.com.agricolab.repository.model.ProdutorEntity;
import br.com.agricolab.repository.model.ProdutosEntity;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    public ProdutorEntity login(String email, String password) throws Exception{

        ProdutorEntity userLogin = produtorRepository.findByEmailProdutorAndSenhaProdutor(email, password);

        if (userLogin == null){
            throw new Exception("bad credentials");
        }

        return userLogin;

    }

    public List<ProdutorEntity> findNearProd(BigDecimal range, BigDecimal latitudeConsumidor, BigDecimal longitudeConsumidor) {
        //"SELECT * FROM produtores p WHERE SQRT((POW(p.lat_produtor,2) - POW(?2,2)) + (POW(p.long_produtor,2) - POW(?3,2))) <= ?1"
        List<ProdutorEntity> produtores = produtorRepository.findAll();
        List<ProdutorEntity> produtorEncontrado = new ArrayList<>();

       // produtores.stream().forEach(produtor -> Math.sqrt((Math.pow(produtor.getLatitudeProdutor().doubleValue(), 2) - Math.pow(latitudeConsumidor.doubleValue(), 2)) + (Math.pow(produtor.getLongitudeProdutor().doubleValue(), 2)
       //         - Math.pow(longitudeConsumidor.doubleValue(), 2))));


        for(ProdutorEntity produtor : produtores) {

            if (produtor.getLatitudeProdutor() != null && produtor.getLongitudeProdutor() != null) {
                if (Math.sqrt((Math.pow(produtor.getLatitudeProdutor().doubleValue(), 2) - Math.pow(latitudeConsumidor.doubleValue(), 2)) + (Math.pow(produtor.getLongitudeProdutor().doubleValue(), 2)
                        - Math.pow(longitudeConsumidor.doubleValue(), 2))) <= range.doubleValue()) {
                    produtorEncontrado.add(produtor);
                }
            }
        }

        return produtorEncontrado;


    }


}
