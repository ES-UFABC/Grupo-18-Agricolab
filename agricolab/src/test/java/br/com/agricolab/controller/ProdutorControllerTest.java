package br.com.agricolab.controller;

import br.com.agricolab.core.produtor.dto.ProdutorDto;
import br.com.agricolab.core.produtor.mapper.ProdutorDtoMapper;
import br.com.agricolab.core.produtor.processors.ProdutorProcessor;
import br.com.agricolab.domain.Produto;
import br.com.agricolab.domain.Produtor;
import br.com.agricolab.repository.adapter.ProdutoRepository;
import br.com.agricolab.repository.adapter.ProdutorRepository;
import br.com.agricolab.repository.mapper.ProdutorEntityMapper;
import br.com.agricolab.repository.model.ProdutorEntity;
import br.com.agricolab.service.ProdutorService;
import br.com.agricolab.templates.ProdutorEntityTemplate;
import br.com.agricolab.templates.ProdutorDtoTemplate;
import br.com.agricolab.templates.ProdutorTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

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

    @Spy
    ProdutorEntityMapper produtorEntityMapper = ProdutorEntityMapper.INSTANCE;

    @Spy
    ProdutorDtoMapper produtorDtoMapper = ProdutorDtoMapper.INSTANCE;

    @InjectMocks
    ProdutorController produtorController;

    @Before
    public void setup(){
        FixtureFactoryLoader.loadTemplates("br.com.agricolab.templates");


    }

    @Test
    public void findAllSucesso(){
        final ProdutorEntity produtorEntity = Fixture.from(ProdutorEntity.class).gimme(ProdutorEntityTemplate.PRODUTOR_VALIDO);

        List<ProdutorEntity> produtores = List.of(produtorEntity);

        when(produtorRepository.findAll()).thenReturn(produtores);

        produtorController.findAll();

        Assertions.assertThat(produtorController.findAll()).isEqualTo(produtores);

    }

    @Test
    public void findByIdSucesso(){
        final ProdutorEntity produtorEntity = Fixture.from(ProdutorEntity.class).gimme(ProdutorEntityTemplate.PRODUTOR_VALIDO);

        final Produtor produtor = Fixture.from(Produtor.class).gimme(ProdutorTemplate.VALIDO);

        final ProdutorDto produtorDto = Fixture.from(ProdutorDto.class).gimme(ProdutorDtoTemplate.VALIDO);

        when(produtorRepository.findById(1)).thenReturn(Optional.ofNullable(produtorEntity));

        when(produtorEntityMapper.produtorToEntity(produtorEntity)).thenReturn(produtor);

        when(produtorDtoMapper.produtorToDto(produtor)).thenReturn(produtorDto);


        produtorController.findById(1);

        Assertions.assertThat(produtorController.findById(1)).isEqualTo(produtorDto);


    }

    @Test
    public void deveDeletarProdutor(){

        Assertions.assertThatCode(() -> produtorController.deleteProdutor(1)).doesNotThrowAnyException();

        ResponseEntity<Void> entity = produtorController.deleteProdutor(1);

        Assertions.assertThat(entity).isNotNull();

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);


    }

    @Test
    public void deveDeletarProduto(){

        Assertions.assertThatCode(() -> produtorController.deleteProdutos(1)).doesNotThrowAnyException();

        ResponseEntity<Void> entity = produtorController.deleteProdutos(1);

        Assertions.assertThat(entity).isNotNull();

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);


    }



}
