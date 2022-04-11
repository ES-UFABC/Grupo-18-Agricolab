package br.com.agricolab.core.produtor.processors;

import br.com.agricolab.core.produtor.mapper.ProdutorDtoMapper;
import br.com.agricolab.domain.Produtor;
import br.com.agricolab.repository.adapter.ProdutorRepository;
import br.com.agricolab.repository.mapper.ProdutorEntityMapper;
import br.com.agricolab.repository.model.ProdutorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class ProdutorProcessor {

    @Autowired
    private ProdutorRepository produtorRepository;



    public Produtor createProdutor(Produtor produtor){
        ProdutorEntity produtorEntity = ProdutorEntityMapper.INSTANCE.produtorToEntity(produtor);

        try {
            produtorRepository.save(produtorEntity);
        }catch(DataIntegrityViolationException e){
            throw new RuntimeException("Produtor já exite para esse email");
        }

        return ProdutorEntityMapper.INSTANCE.produtorToEntity(produtorEntity);
    }

    public Produtor modificaProdutor(Produtor produtorRequest, int id){

        ProdutorEntity produtorEntity = produtorRepository.findByIdProdutor(id);

        if(produtorEntity == null){
            produtorRequest.setId(id);
            return this.createProdutor(produtorRequest);
        }

        Produtor produtor = ProdutorEntityMapper.INSTANCE.produtorToEntity(produtorEntity);

        produtor =  ProdutorDtoMapper.INSTANCE.updateProdutor(produtor,produtorRequest);

        ProdutorEntity produtorEntityNovo = ProdutorEntityMapper.INSTANCE.produtorToEntity(produtor);

        try {
            produtorRepository.save(produtorEntityNovo);
        }catch(DataIntegrityViolationException e){
            throw new RuntimeException("Produtor já exite para esse email");
        }

        return produtor;
    }

}
