package br.com.agricolab.controller;

import br.com.agricolab.core.consumidor.dto.ConsumidorDto;
import br.com.agricolab.core.consumidor.mapper.ConsumidorDtoMapper;
import br.com.agricolab.core.consumidor.processors.ConsumidorProcessor;
import br.com.agricolab.domain.Consumidor;
import br.com.agricolab.domain.Pedido;
import br.com.agricolab.domain.Produto;
import br.com.agricolab.domain.Produtor;
import br.com.agricolab.repository.adapter.ConsumidorRepository;
import br.com.agricolab.repository.adapter.PedidosRepository;
import br.com.agricolab.repository.adapter.ProdutorRepository;
import br.com.agricolab.repository.mapper.ConsumidorEntityMapper;
import br.com.agricolab.repository.model.ConsumidorEntity;
import br.com.agricolab.repository.model.PedidosEntity;
import br.com.agricolab.repository.model.ProdutorEntity;
import br.com.agricolab.repository.model.ProdutosEntity;
import br.com.agricolab.service.ProdutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/consumidor")
public class ConsumidorController {

    @Autowired
    private ConsumidorRepository consumidorRepository;

    @Autowired
    private ConsumidorProcessor consumidorProcessor;

    @Autowired
    private ProdutorRepository produtorRepository;

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private ProdutorService produtorService;


    @GetMapping(path = "/all")
    public List findAll(){
        return consumidorRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ConsumidorDto findById(@PathVariable Integer id){
        Optional<ConsumidorEntity> consumidorEntity = consumidorRepository.findById(id);

        if(consumidorEntity.isPresent()){
            Consumidor consumidor = ConsumidorEntityMapper.INSTANCE.ConsumidorToEntity(consumidorEntity.get());
            return ConsumidorDtoMapper.INSTANCE.consumidorToDto(consumidor);
        }
        return new ConsumidorDto();
    }

    //    API que aciona a query que calcula e filtra os produtores por raio

    @GetMapping(path = {"/nextprodutores/{latitudeConsumidor}/{longitudeConsumidor}"})
    public List<ProdutorEntity> findNearProdutores(@PathVariable Double latitudeConsumidor, @PathVariable Double longitudeConsumidor){
        //return produtorRepository.findNearProd(new BigDecimal("3.0"), latitudeConsumidor,longitudeConsumidor);
        return produtorService.findNearProd(3.0, latitudeConsumidor,longitudeConsumidor);


    }


    @PostMapping
    public ConsumidorDto create(@RequestBody ConsumidorDto consumidorRequest){

        Consumidor consumidor = ConsumidorDtoMapper.INSTANCE.consumidorToDto(consumidorRequest);

        consumidor = consumidorProcessor.createConsumidor(consumidor);

        return ConsumidorDtoMapper.INSTANCE.consumidorToDto(consumidor);
    }

    @PatchMapping("/{id}")
    ConsumidorDto modificaConsumidor(@RequestBody ConsumidorDto novoConsumidor, @PathVariable Integer id) {
        Consumidor consumidorRequest = ConsumidorDtoMapper.INSTANCE.consumidorToDto(novoConsumidor);

        Consumidor consumidor = consumidorProcessor.modificaConsumidor(consumidorRequest,id);

        return ConsumidorDtoMapper.INSTANCE.consumidorToDto(consumidor);

    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteConsumidor(@PathVariable Integer id) {
        consumidorRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/pedidos/{idProdutor}/{idConsumidor}")
    public ResponseEntity<ConsumidorEntity> adicionaPedido(@RequestBody List<Pedido> pedidosConsumidor, @PathVariable Integer idProdutor, @PathVariable Integer idConsumidor) throws Exception {
        ProdutorEntity produtor = produtorRepository.findByIdProdutor(idProdutor);
        ConsumidorEntity consumidorPedidos = consumidorRepository.findByIdConsumidor(idConsumidor);

        return ResponseEntity.ok(consumidorProcessor.registroPedidos(produtor, pedidosConsumidor, consumidorPedidos));
    }

    @DeleteMapping("/delete/pedido/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Integer id){
        pedidosRepository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/alterar/pedido/{id}")
    public ResponseEntity<Void> alterarPedido(@RequestBody Pedido pedidoNovo, @PathVariable Integer id){
        consumidorProcessor.replace(pedidoNovo, id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping(path = "/pedido/all")
    public List findAllPedidos(){
        return pedidosRepository.findAll();
    }

}
