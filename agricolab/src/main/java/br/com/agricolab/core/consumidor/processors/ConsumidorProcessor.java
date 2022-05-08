package br.com.agricolab.core.consumidor.processors;

import br.com.agricolab.core.consumidor.mapper.ConsumidorDtoMapper;
import br.com.agricolab.core.produtos.mapper.ProdutosMapper;
import br.com.agricolab.domain.Consumidor;
import br.com.agricolab.domain.Pedido;
import br.com.agricolab.domain.Produto;
import br.com.agricolab.repository.adapter.ConsumidorRepository;
import br.com.agricolab.repository.adapter.PedidosRepository;
import br.com.agricolab.repository.mapper.ConsumidorEntityMapper;
import br.com.agricolab.repository.model.ConsumidorEntity;
import br.com.agricolab.repository.model.PedidosEntity;
import br.com.agricolab.repository.model.ProdutorEntity;
import br.com.agricolab.repository.model.ProdutosEntity;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ConsumidorProcessor {

    private final ProdutosMapper mapper = Mappers.getMapper(ProdutosMapper.class);

    @Autowired
    private ConsumidorRepository consumidorRepository;

    @Autowired
    private PedidosRepository pedidosRepository;


    public Consumidor createConsumidor(Consumidor Consumidor){
        ConsumidorEntity ConsumidorEntity = ConsumidorEntityMapper.INSTANCE.ConsumidorToEntity(Consumidor);

        try {
            consumidorRepository.save(ConsumidorEntity);
        }catch(DataIntegrityViolationException e){
            throw new RuntimeException("Consumidor já exite para esse email");
        }

        return ConsumidorEntityMapper.INSTANCE.ConsumidorToEntity(ConsumidorEntity);
    }

    public Consumidor modificaConsumidor(Consumidor ConsumidorRequest, int id){

        ConsumidorEntity ConsumidorEntity = consumidorRepository.findByIdConsumidor(id);

        if(ConsumidorEntity == null){
            ConsumidorRequest.setId(id);
            return this.createConsumidor(ConsumidorRequest);
        }

        Consumidor consumidor = ConsumidorEntityMapper.INSTANCE.ConsumidorToEntity(ConsumidorEntity);

        consumidor =  ConsumidorDtoMapper.INSTANCE.updateConsumidor(consumidor,ConsumidorRequest);

        ConsumidorEntity ConsumidorEntityNovo = ConsumidorEntityMapper.INSTANCE.ConsumidorToEntity(consumidor);

        try {
            consumidorRepository.save(ConsumidorEntityNovo);
        }catch(DataIntegrityViolationException e){
            throw new RuntimeException("Consumidor já exite para esse email");
        }

        return consumidor;
    }

    public ConsumidorEntity registroPedidos(ProdutorEntity produtor, List<Pedido> pedidos, ConsumidorEntity consumidorPedidos) throws Exception {


    for(Pedido produto : pedidos) {
        produtor.getProdutos().stream().forEach(
                con -> {
                    if (con.getNomeProduto().equals(produto.getNomePedido())) {
                        con.setQuantidadeProduto(con.getQuantidadeProduto() - produto.getQuantidadePedido());
                        produto.setValorPedido(BigDecimal.valueOf(produto.getQuantidadePedido()).multiply(con.getValorProduto()));

                        PedidosEntity pedidosEntity = mapper.toPedidos(produto);

                        pedidosRepository.save(pedidosEntity);
                        consumidorPedidos.getPedidos().add(pedidosEntity);

                    }


                });

        List<ProdutosEntity> produtosNome = produtor.getProdutos();

        for (ProdutosEntity produtoNome : produtosNome) {
            if (produtoNome.getNomeProduto().equals(produto.getNomePedido())) {
                consumidorRepository.save(consumidorPedidos);
            }

        }
    }

        return consumidorPedidos;



}

    public void replace(Pedido pedidoNovo, Integer id) {

        PedidosEntity pedido = pedidosRepository.findByIdPedido(id);

        pedido.setNomePedido(pedidoNovo.getNomePedido());
        pedido.setValorPedido(pedidoNovo.getValorPedido());
        pedido.setQuantidadePedido(pedidoNovo.getQuantidadePedido());



        pedidosRepository.save(pedido);
    }
}