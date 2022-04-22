package br.com.agricolab.controller;


import br.com.agricolab.core.consumidor.processors.ConsumidorProcessor;
import br.com.agricolab.repository.adapter.ConsumidorRepository;
import br.com.agricolab.repository.adapter.PedidosRepository;
import br.com.agricolab.repository.adapter.ProdutorRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ConsumidorControllerTest {

    @Mock
    ConsumidorRepository consumidorRepository;

    @Mock
    ConsumidorProcessor consumidorProcessor;

    @Mock
    ProdutorRepository produtorRepository;

    @Mock
    PedidosRepository pedidosRepository;

    @InjectMocks
    ConsumidorController consumidorController;

}
