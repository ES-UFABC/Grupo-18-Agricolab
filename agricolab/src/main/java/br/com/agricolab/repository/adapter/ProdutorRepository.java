package br.com.agricolab.repository.adapter;

import br.com.agricolab.repository.model.ProdutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutorRepository extends JpaRepository<ProdutorEntity, Integer> {

    ProdutorEntity findByIdProdutor(Integer idProdutor);


}