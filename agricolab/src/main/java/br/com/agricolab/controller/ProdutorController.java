package br.com.agricolab.controller;

import br.com.agricolab.domain.Produto;
import br.com.agricolab.repository.adapter.ProdutorRepository;
import br.com.agricolab.repository.model.ProdutorEntity;
import br.com.agricolab.repository.model.ProdutosEntity;
import br.com.agricolab.service.ProdutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtor")
public class ProdutorController {

    @Autowired
    private ProdutorRepository produtorRepository;

    @Autowired
    ProdutorService produtorService;

    @GetMapping(path = "/all")
    public List findAll(){
        return produtorRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Integer id){
        return produtorRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProdutorEntity create(@RequestBody ProdutorEntity produtor){
        return produtorRepository.save(produtor);
    }

    @PutMapping("/{id}")
    ProdutorEntity modificaProdutor(@RequestBody ProdutorEntity novoProdutor, @PathVariable Integer id) {

        return produtorRepository.findById(id)
                .map(produtor -> {
                    produtor.setCpfProdutor(novoProdutor.getCpfProdutor());
                    produtor.setCnpjProdutor(novoProdutor.getCnpjProdutor());
                    produtor.setEmailProdutor(novoProdutor.getEmailProdutor());
                    produtor.setEnderecoProdutor(novoProdutor.getEnderecoProdutor());
                    produtor.setTelefoneProdutor(novoProdutor.getTelefoneProdutor());
                    return produtorRepository.save(produtor);
                })
                .orElseGet(() -> {
                    novoProdutor.setIdProdutor(id);
                    return produtorRepository.save(novoProdutor);
                });
    }

    @DeleteMapping("/{id}")
    void deleteProdutor(@PathVariable Integer id) {
        produtorRepository.deleteById(id);
    }


    @PostMapping("/cadastro/produto/{id}")
    public ResponseEntity<ProdutorEntity> cadastroProdutos(@RequestBody Produto produtos, @PathVariable Integer id){
        return ResponseEntity.ok(produtorService.cadastro(id, produtos));

    }

    @DeleteMapping("/delete/produto/{id}")
    public ResponseEntity<Void> deleteProdutos(@PathVariable Integer id){
        produtorService.delete(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/alterar/produto/{id}")
    public ResponseEntity<Void> alterarProduto(@RequestBody Produto produtoNovo, @PathVariable Integer id){
        produtorService.replace(produtoNovo, id);
        return ResponseEntity.noContent().build();

    }


}

