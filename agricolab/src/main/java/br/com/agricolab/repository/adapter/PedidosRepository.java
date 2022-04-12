package br.com.agricolab.repository.adapter;


import br.com.agricolab.repository.model.PedidosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends JpaRepository<PedidosEntity, Integer> {

    PedidosEntity findByIdPedido(Integer id);

}
