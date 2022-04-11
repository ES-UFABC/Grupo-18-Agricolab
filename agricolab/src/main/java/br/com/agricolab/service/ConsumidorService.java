package br.com.agricolab.service;

import br.com.agricolab.repository.adapter.ConsumidorRepository;
import br.com.agricolab.repository.model.ConsumidorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumidorService {

    @Autowired
    ConsumidorRepository consumidorRepository;


    public ConsumidorEntity login(String email, String password) throws Exception{

        ConsumidorEntity userLogin = consumidorRepository.findByEmailConsumidorAndSenhaConsumidor(email, password);

        if (userLogin == null){
            throw new Exception("bad credentials");
        }

        return userLogin;

    }

}
