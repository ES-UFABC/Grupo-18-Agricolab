package br.com.agricolab.repository.adapter;

import br.com.agricolab.repository.model.ProdutosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutoRepository extends JpaRepository<ProdutosEntity, Integer> {

    ProdutosEntity findByIdProduto(Integer id);
}

