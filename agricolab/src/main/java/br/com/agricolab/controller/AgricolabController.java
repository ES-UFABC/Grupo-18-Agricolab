package br.com.agricolab.controller;


import br.com.agricolab.repository.model.ConsumidorEntity;
import br.com.agricolab.service.ConsumidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agricolab/v1")
public class AgricolabController {

    @Autowired
    ConsumidorService consumidorService;



    @PostMapping(path ="/login")
    public ResponseEntity<ConsumidorEntity> loginUser(@RequestBody ConsumidorEntity request) throws Exception {
        String email = request.getEmailConsumidor();
        String password = request.getSenhaConsumidor();

        if (email != null && password != null) {
            return ResponseEntity.ok(consumidorService.login(email, password));
        }
        return null;
    }


}
