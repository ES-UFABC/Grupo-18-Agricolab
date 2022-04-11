package br.com.agricolab.core.consumidor.processors;

import br.com.agricolab.core.consumidor.mapper.ConsumidorDtoMapper;
import br.com.agricolab.domain.Consumidor;
import br.com.agricolab.repository.adapter.ConsumidorRepository;
import br.com.agricolab.repository.mapper.ConsumidorEntityMapper;
import br.com.agricolab.repository.model.ConsumidorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorProcessor {

    @Autowired
    private ConsumidorRepository consumidorRepository;


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

}