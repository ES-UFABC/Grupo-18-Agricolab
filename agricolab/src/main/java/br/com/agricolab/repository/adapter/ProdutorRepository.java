package br.com.agricolab.repository.adapter;

import br.com.agricolab.domain.Produtor;
import br.com.agricolab.repository.model.ProdutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutorRepository extends JpaRepository<ProdutorEntity, Integer> {

    ProdutorEntity findByIdProdutor(Integer idProdutor);

    ProdutorEntity findByEmailProdutorAndSenhaProdutor(String email, String password);

    boolean findByEmailProdutor(String email);

    //    Query que calcula os raios até os produtores e filtra os menores que um raio determinado
    @Query("select p from produtores p where SQRT((POW(p.lat_produtor,2) - POW(p.lat_consumidor,2)) + (POW(p.long_produtor,2) - POW(p.long_consumidor,2))) <= ?1")
    List<Produtor> findNearProd(Double range, Double latitudeConsumidor, Double longitudeConsumidor);
}