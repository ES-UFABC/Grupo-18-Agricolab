package br.com.agricolab.controller;


import br.com.agricolab.core.consumidor.processors.ConsumidorProcessor;
import br.com.agricolab.repository.adapter.ConsumidorRepository;
import br.com.agricolab.repository.adapter.PedidosRepository;
import br.com.agricolab.repository.adapter.ProdutorRepository;
import br.com.agricolab.repository.model.ConsumidorEntity;
import br.com.agricolab.templates.ConsumidorEntityTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.mockito.Mockito.when;

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

    @Before
    public void setup(){
        FixtureFactoryLoader.loadTemplates("br.com.agricolab.templates");

        final ConsumidorEntity consumidorEntity = Fixture.from(ConsumidorEntity.class).gimme(ConsumidorEntityTemplate.LOGIN);



    }

    @Test
    public void findAllSucesso(){

        final ConsumidorEntity consumidorEntity = Fixture.from(ConsumidorEntity.class).gimme(ConsumidorEntityTemplate.LOGIN);

        List<ConsumidorEntity> consumidores = List.of(consumidorEntity);

        when(consumidorRepository.findAll()).thenReturn(consumidores);

        consumidorController.findAll();

        Assertions.assertThat(consumidorController.findAll()).isEqualTo(consumidores);
    }

    @Test
    public void findByIdSucesso(){
        final ConsumidorEntity consumidorEntity = Fixture.from(ConsumidorEntity.class).gimme(ConsumidorEntityTemplate.LOGIN);



    }
}
