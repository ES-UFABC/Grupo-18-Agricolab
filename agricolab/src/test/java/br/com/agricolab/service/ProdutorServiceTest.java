package br.com.agricolab.service;

import br.com.agricolab.core.produtor.dto.ProdutorDto;
import br.com.agricolab.domain.Produto;
import br.com.agricolab.domain.Produtor;
import br.com.agricolab.repository.adapter.ProdutoRepository;
import br.com.agricolab.repository.adapter.ProdutorRepository;
import br.com.agricolab.repository.model.ProdutorEntity;
import br.com.agricolab.repository.model.ProdutosEntity;
import br.com.agricolab.templates.*;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
public class ProdutorServiceTest {

    @Mock
    ProdutorRepository produtorRepository;

    @Mock
    ProdutoRepository produtoRepository;

    @InjectMocks
    ProdutorService produtorService;

    @Before
    public void setup(){
        FixtureFactoryLoader.loadTemplates("br.com.agricolab.templates");

    }

    @Test
    public void deveCadastrar() throws Exception {

        final ProdutorEntity produtorEntity = Fixture.from(ProdutorEntity.class).gimme(ProdutorEntityTemplate.PRODUTOR_VALIDO);

        final Produto produto = Fixture.from(Produto.class).gimme(ProdutoTemplate.VALIDO);
        final ProdutosEntity produtos = Fixture.from(ProdutosEntity.class).gimme(ProdutosEntityTemplate.VALIDO);

        Mockito.when(produtorRepository.findByIdProdutor(1)).thenReturn(produtorEntity);
        Mockito.when(produtoRepository.save(produtos)).thenReturn(Mockito.any());
       Mockito.when(produtorRepository.save(produtorEntity)).thenReturn(produtorEntity);


        Assertions.assertThat(produtorService.cadastro(1, produto)).isEqualTo(produtorEntity);

    }

    @Test
    public void deveEncontrarProdutores(){

        final ProdutorEntity produtorEntity = Fixture.from(ProdutorEntity.class).gimme(ProdutorEntityTemplate.PRODUTOR_VALIDO);
        List<ProdutorEntity> produtores = new ArrayList<>();
        produtores.add(produtorEntity);

        Mockito.when(produtorRepository.findAll()).thenReturn(produtores);
        Assertions.assertThat(produtorService.findNearProd(3.0, 15.1221, 12.1221)).isEqualTo(produtores);

        }


}
