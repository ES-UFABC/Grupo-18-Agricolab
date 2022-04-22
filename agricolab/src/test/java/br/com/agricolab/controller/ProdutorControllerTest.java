package br.com.agricolab.controller;

import br.com.agricolab.core.produtor.processors.ProdutorProcessor;
import br.com.agricolab.repository.adapter.ProdutoRepository;
import br.com.agricolab.repository.adapter.ProdutorRepository;
import br.com.agricolab.service.ProdutorService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProdutorControllerTest {

    @Mock
    ProdutorRepository produtorRepository;

    @Mock
    ProdutoRepository produtoRepository;

    @Mock
    ProdutorProcessor produtorProcessor;

    @Mock
    ProdutorService produtorService;

    @InjectMocks
    ProdutorController produtorController;



}
