package br.com.agricolab.controller;

import br.com.agricolab.core.produtor.dto.ProdutorDto;
import br.com.agricolab.core.produtor.mapper.ProdutorDtoMapper;
import br.com.agricolab.core.produtor.processors.ProdutorProcessor;
import br.com.agricolab.domain.Produtor;
import br.com.agricolab.domain.Produto;
import br.com.agricolab.repository.adapter.ProdutoRepository;
import br.com.agricolab.repository.adapter.ProdutorRepository;
import br.com.agricolab.repository.mapper.ProdutorEntityMapper;
import br.com.agricolab.repository.model.ProdutorEntity;
import br.com.agricolab.service.ProdutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/produtor")
public class ProdutorController {

    @Autowired
    private ProdutorRepository produtorRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutorProcessor produtorProcessor;

    @Autowired
    ProdutorService produtorService;

    ProdutorController(ProdutorRepository produtorRepository, ProdutorProcessor produtorProcessor) {
        this.produtorRepository = produtorRepository;
        this.produtorProcessor = produtorProcessor;
    }

    @GetMapping(path = "/all")
    public List findAll(){
        return produtorRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ProdutorDto findById(@PathVariable Integer id){
        final Optional<ProdutorEntity> produtorEntity = produtorRepository.findById(id);

        if(produtorEntity.isPresent()){
            final Produtor produtor = ProdutorEntityMapper.INSTANCE.produtorToEntity(produtorEntity.get());
            return ProdutorDtoMapper.INSTANCE.produtorToDto(produtor);
        }
        return new ProdutorDto();
    }

    @PostMapping
    public ProdutorDto create(@RequestBody ProdutorDto produtorResquest){

        Produtor produtor = ProdutorDtoMapper.INSTANCE.produtorToDto(produtorResquest);

        produtor = produtorProcessor.createProdutor(produtor);

        return ProdutorDtoMapper.INSTANCE.produtorToDto(produtor);
    }

    @PatchMapping("/{id}")
    ProdutorDto modificaProdutor(@RequestBody ProdutorDto novoProdutor, @PathVariable Integer id) {

        final Produtor produtorRequest = ProdutorDtoMapper.INSTANCE.produtorToDto(novoProdutor);

        final Produtor produtor = produtorProcessor.modificaProdutor(produtorRequest,id);

        return ProdutorDtoMapper.INSTANCE.produtorToDto(produtor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdutor(@PathVariable Integer id) {
        produtorRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/cadastro/produto/{id}")
    public ResponseEntity<ProdutorEntity> cadastroProdutos(@RequestBody Produto produtos, @PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(produtorService.cadastro(id, produtos));

    }

    @DeleteMapping("/delete/produto/{id}")
    public ResponseEntity<Void> deleteProdutos(@PathVariable Integer id){
        produtoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("/alterar/produto/{id}")
    public ResponseEntity<Void> alterarProduto(@RequestBody Produto produtoNovo, @PathVariable Integer id){
        produtorService.replace(produtoNovo, id);
        return ResponseEntity.noContent().build();

    }
    
    @GetMapping(path = "/produto/all")
    public List findAllProdutos(){
        return produtoRepository.findAll();
    }


}

