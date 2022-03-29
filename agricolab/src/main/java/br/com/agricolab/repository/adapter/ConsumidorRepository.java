package br.com.agricolab.repository.adapter;


import br.com.agricolab.repository.model.ConsumidorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumidorRepository extends JpaRepository<ConsumidorEntity, Integer> {


    ConsumidorEntity findByEmailConsumidorAndSenhaConsumidor(String emailConsumidor, String senhaConsumidor);
}