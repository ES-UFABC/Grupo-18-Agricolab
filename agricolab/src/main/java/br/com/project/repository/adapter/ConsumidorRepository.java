package br.com.project.repository.adapter;


import br.com.project.repository.model.ConsumidorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumidorRepository extends JpaRepository<ConsumidorEntity, Integer> {
}