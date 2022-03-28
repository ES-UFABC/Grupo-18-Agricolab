package br.com.project.repository.adapter;

import br.com.project.repository.model.ProdutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutorRepository extends JpaRepository<ProdutorEntity, Integer> {
}