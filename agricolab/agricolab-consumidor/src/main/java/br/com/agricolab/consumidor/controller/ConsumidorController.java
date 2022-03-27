package br.com.agricolab.consumidor.controller;


import br.com.agricolab.repository.adapter.ConsumidorRepository;
import br.com.agricolab.repository.model.ConsumidorEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping({"/consumidor"})
public class ConsumidorController {

    private ConsumidorRepository consumidorRepository;

    ConsumidorController(ConsumidorRepository consumidorRepository) {
        this.consumidorRepository = consumidorRepository;
    }

    @GetMapping
    public List findAll(){
        return consumidorRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Integer id){
        return consumidorRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ConsumidorEntity create(@RequestBody ConsumidorEntity produtor){


        return consumidorRepository.save(produtor);
    }

    @PutMapping("/{id}")
    ConsumidorEntity modificaProdutor(@RequestBody ConsumidorEntity novoConsumidor, @PathVariable Integer id) {

        return consumidorRepository.findById(id)
                .map(consumidor -> {
                    consumidor.setCpfConsumidor(novoConsumidor.getCpfConsumidor());
                    consumidor.setCnpjConsumidor(novoConsumidor.getCnpjConsumidor());
                    consumidor.setEmailConsumidor(novoConsumidor.getEmailConsumidor());
                    consumidor.setEnderecoConsumidor(novoConsumidor.getEnderecoConsumidor());
                    consumidor.setTelefoneConsumidor(novoConsumidor.getTelefoneConsumidor());
                    consumidor.setLatitudeConsumidor(novoConsumidor.getLatitudeConsumidor());
                    consumidor.setLongitudeConsumidor(novoConsumidor.getLongitudeConsumidor());
                    consumidor.setNomeConsumidor(novoConsumidor.getNomeConsumidor());
                    consumidor.setSegmentoConsumidorPJ(novoConsumidor.getSegmentoConsumidorPJ());
                    consumidor.setTipoConsumidor(novoConsumidor.getTipoConsumidor());
                    consumidor.setComplementoEnderecoconsumidor(novoConsumidor.getComplementoEnderecoconsumidor());
                    return consumidorRepository.save(consumidor);
                })
                .orElseGet(() -> {
                    novoConsumidor.setIdConsumidor(id);
                    return consumidorRepository.save(novoConsumidor);
                });
    }

    @DeleteMapping("/{id}")
    void deleteProdutor(@PathVariable Integer id) {
        consumidorRepository.deleteById(id);
    }

}
