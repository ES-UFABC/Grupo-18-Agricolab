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
import br.com.agricolab.repository.model.PedidosEntity;
import br.com.agricolab.repository.model.ProdutorEntity;
import br.com.agricolab.service.ProdutorService;
import br.com.agricolab.templates.*;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
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
    ProdutorService produtorService;

    @Mock
    PedidosRepository pedidosRepository;

    @InjectMocks
    ConsumidorController consumidorController;

    @Spy
    ConsumidorDtoMapper consumidorDtoMapper = ConsumidorDtoMapper.INSTANCE;

    @Spy
    ConsumidorEntityMapper consumidorEntityMapper = ConsumidorEntityMapper.INSTANCE;

    @Before
    public void setup() {
        FixtureFactoryLoader.loadTemplates("br.com.agricolab.templates");

    }

    @Test
    public void findAllSucesso() {

        final ConsumidorEntity consumidorEntity = Fixture.from(ConsumidorEntity.class).gimme(ConsumidorEntityTemplate.VALIDO);

        List<ConsumidorEntity> consumidores = List.of(consumidorEntity);

        when(consumidorRepository.findAll()).thenReturn(consumidores);

        consumidorController.findAll();

        Assertions.assertThat(consumidorController.findAll()).isEqualTo(consumidores);
    }

    @Test
    public void findAllPedidoSucesso() {

        final PedidosEntity pedidosEntity = Fixture.from(PedidosEntity.class).gimme(PedidosEntityTemplate.VALIDO);

        List<PedidosEntity> pedidos = List.of(pedidosEntity);

        when(pedidosRepository.findAll()).thenReturn(pedidos);

        consumidorController.findAllPedidos();

        Assertions.assertThat(consumidorController.findAllPedidos()).isEqualTo(pedidos);
    }

    @Test
    public void findByIdSucesso() {
        final ConsumidorEntity consumidorEntity = Fixture.from(ConsumidorEntity.class).gimme(ConsumidorEntityTemplate.VALIDO);

        final Consumidor consumidor = Fixture.from(Consumidor.class).gimme(ConsumidorTemplate.VALIDO);

        final ConsumidorDto consumidorDto = Fixture.from(ConsumidorDto.class).gimme(ConsumidorDtoTemplate.VALIDO);

        when(consumidorRepository.findById(1)).thenReturn(Optional.ofNullable(consumidorEntity));

        when(consumidorEntityMapper.consumidorToEntity(consumidorEntity)).thenReturn(consumidor);
        when(consumidorDtoMapper.consumidorToDto(consumidor)).thenReturn(consumidorDto);

        consumidorController.findById(1);

        Assertions.assertThat(consumidorController.findById(1)).isEqualTo(consumidorDto);


    }

    @Test
    public void deveDeletarConsumidor() {

        Assertions.assertThatCode(() -> consumidorController.deleteConsumidor(1)).doesNotThrowAnyException();

        ResponseEntity<Void> entity = consumidorController.deleteConsumidor(1);

        Assertions.assertThat(entity).isNotNull();

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);


    }

    @Test
    public void deveDeletarPedido() {

        Assertions.assertThatCode(() -> consumidorController.deletePedido(1)).doesNotThrowAnyException();

        ResponseEntity<Void> entity = consumidorController.deletePedido(1);

        Assertions.assertThat(entity).isNotNull();

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);


    }

    @Test
    public void deveRetornarValorProdutores() {

        final ProdutorEntity produtorEntity = Fixture.from(ProdutorEntity.class).gimme(ProdutorEntityTemplate.PRODUTOR_VALIDO);
        List<ProdutorEntity> produtores = new ArrayList<>();
        produtores.add(produtorEntity);

        when(produtorService.findNearProd(3.0, 15.1221, 12.1221)).thenReturn(produtores);

        Assertions.assertThat(consumidorController.findNearProdutores(15.1221, 12.1221)).isEqualTo(produtores);

    }

}


