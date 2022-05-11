package br.com.agricolab.controller;


import br.com.agricolab.core.consumidor.dto.ConsumidorDto;
import br.com.agricolab.core.consumidor.mapper.ConsumidorDtoMapper;
import br.com.agricolab.core.consumidor.processors.ConsumidorProcessor;
import br.com.agricolab.domain.Consumidor;
import br.com.agricolab.repository.adapter.ConsumidorRepository;
import br.com.agricolab.repository.adapter.PedidosRepository;
import br.com.agricolab.repository.adapter.ProdutorRepository;
import br.com.agricolab.repository.mapper.ConsumidorEntityMapper;
import br.com.agricolab.repository.model.ConsumidorEntity;
import br.com.agricolab.templates.ConsumidorDtoTemplate;
import br.com.agricolab.templates.ConsumidorEntityTemplate;
import br.com.agricolab.templates.ConsumidorTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

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

    @Spy
    ConsumidorDtoMapper consumidorDtoMapper = ConsumidorDtoMapper.INSTANCE;

    @Spy
    ConsumidorEntityMapper consumidorEntityMapper = ConsumidorEntityMapper.INSTANCE;

    @Before
    public void setup(){
        FixtureFactoryLoader.loadTemplates("br.com.agricolab.templates");

    }

    @Test
    public void findAllSucesso(){

        final ConsumidorEntity consumidorEntity = Fixture.from(ConsumidorEntity.class).gimme(ConsumidorEntityTemplate.VALIDO);

        List<ConsumidorEntity> consumidores = List.of(consumidorEntity);

        when(consumidorRepository.findAll()).thenReturn(consumidores);

        consumidorController.findAll();

        Assertions.assertThat(consumidorController.findAll()).isEqualTo(consumidores);
    }

    @Test
    public void findByIdSucesso(){
        final ConsumidorEntity consumidorEntity = Fixture.from(ConsumidorEntity.class).gimme(ConsumidorEntityTemplate.VALIDO);

        final Consumidor consumidor = Fixture.from(Consumidor.class).gimme(ConsumidorTemplate.VALIDO);

        final ConsumidorDto consumidorDto = Fixture.from(ConsumidorDto.class).gimme(ConsumidorDtoTemplate.VALIDO);

        when(consumidorRepository.findById(1)).thenReturn(Optional.ofNullable(consumidorEntity));

        when(consumidorEntityMapper.ConsumidorToEntity(consumidorEntity)).thenReturn(consumidor);
        when(consumidorDtoMapper.consumidorToDto(consumidor)).thenReturn(consumidorDto);

        consumidorController.findById(1);

        Assertions.assertThat(consumidorController.findById(1)).isEqualTo(consumidorDto);



    }
}
