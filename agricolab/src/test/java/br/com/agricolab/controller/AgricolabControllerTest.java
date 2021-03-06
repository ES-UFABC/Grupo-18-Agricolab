package br.com.agricolab.controller;

import br.com.agricolab.repository.adapter.ConsumidorRepository;
import br.com.agricolab.repository.adapter.ProdutorRepository;
import br.com.agricolab.repository.model.ConsumidorEntity;
import br.com.agricolab.repository.model.ProdutorEntity;
import br.com.agricolab.service.ConsumidorService;
import br.com.agricolab.service.ProdutorService;
import br.com.agricolab.templates.ConsumidorEntityTemplate;
import br.com.agricolab.templates.ProdutorEntityTemplate;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class AgricolabControllerTest {

    @Mock
    ConsumidorService consumidorService;

    @Mock
    ConsumidorRepository consumidorRepository;

    @Mock
    ProdutorRepository produtorRepository;

    @InjectMocks
    AgricolabController agricolabController;

    @Mock
    ProdutorService produtorService;

    @Before
    public void setup(){
        FixtureFactoryLoader.loadTemplates("br.com.agricolab.templates");
    }

    @Test
    public void LoginCorreto() throws Exception {

        final ConsumidorEntity consumidorEntity = Fixture.from(ConsumidorEntity.class).gimme(ConsumidorEntityTemplate.LOGIN);

        Assertions.assertThat(consumidorEntity.getEmailConsumidor()).isNotNull();
        Assertions.assertThat(consumidorEntity.getSenhaConsumidor()).isNotNull();

        when(consumidorService.login(consumidorEntity.getEmailConsumidor(), consumidorEntity.getSenhaConsumidor())).thenReturn(consumidorEntity);


        ResponseEntity <ConsumidorEntity> responseEntity = agricolabController.loginUser(consumidorEntity);

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());


        agricolabController.loginUser(consumidorEntity);
    }

    @Test
    public void LoginCorretoProdutor() throws Exception {

        final ProdutorEntity produtorEntity = Fixture.from(ProdutorEntity.class).gimme(ProdutorEntityTemplate.LOGIN);

        Assertions.assertThat(produtorEntity.getEmailProdutor()).isNotNull();
        Assertions.assertThat(produtorEntity.getSenhaProdutor()).isNotNull();

        when(produtorService.login(produtorEntity.getEmailProdutor(), produtorEntity.getSenhaProdutor())).thenReturn(produtorEntity);

        agricolabController.loginProdutor(produtorEntity);
        ResponseEntity <ProdutorEntity> responseEntity = agricolabController.loginProdutor(produtorEntity);


        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }

    @Test(expected = Exception.class)
    public void LoginIncorreto() throws Exception {

        final ConsumidorEntity consumidorEntity = Fixture.from(ConsumidorEntity.class).gimme(ConsumidorEntityTemplate.LOGIN);

        Assertions.assertThat(consumidorEntity.getEmailConsumidor()).isNotNull();
        Assertions.assertThat(consumidorEntity.getSenhaConsumidor()).isNotNull();

        when(consumidorService.login(consumidorEntity.getEmailConsumidor(), consumidorEntity.getSenhaConsumidor())).thenThrow(Exception.class);

        agricolabController.loginUser(consumidorEntity);

        Assertions.assertThat( agricolabController.loginUser(consumidorEntity)).isEqualTo(consumidorEntity);

    }


    @Test(expected = Exception.class)
    public void LoginProdutorIncorreto() throws Exception {

        final ProdutorEntity produtorEntity = Fixture.from(ProdutorEntity.class).gimme(ProdutorEntityTemplate.LOGIN);

        Assertions.assertThat(produtorEntity.getEmailProdutor()).isNotNull();
        Assertions.assertThat(produtorEntity.getSenhaProdutor()).isNotNull();

        when(produtorService.login(produtorEntity.getEmailProdutor(), produtorEntity.getSenhaProdutor())).thenThrow(Exception.class);

        Assertions.assertThat(agricolabController.loginProdutor(produtorEntity)).isEqualTo(Exception.class);

    }

    @Test
    public void LoginNulo() throws Exception {

        final ConsumidorEntity login = Fixture.from(ConsumidorEntity.class).gimme(ConsumidorEntityTemplate.LOGIN_INCORRETO);

        Assertions.assertThat(login.getEmailConsumidor()).isNotNull();
        Assertions.assertThat(login.getSenhaConsumidor()).isNull();

        agricolabController.loginUser(login);

        Assertions.assertThat(agricolabController.loginUser(login)).isEqualTo(null);

    }

    @Test
    public void LoginProdutorNulo() throws Exception {

        final ProdutorEntity loginProdutor = Fixture.from(ProdutorEntity.class).gimme(ProdutorEntityTemplate.LOGIN_INCORRETO);

        Assertions.assertThat(loginProdutor.getEmailProdutor()).isNotNull();
        Assertions.assertThat(loginProdutor.getSenhaProdutor()).isNull();

        agricolabController.loginProdutor(loginProdutor);

        Assertions.assertThat(agricolabController.loginProdutor(loginProdutor)).isEqualTo(null);

    }

    @Test
    public void validacaoFalse(){

        final ProdutorEntity loginProdutor = Fixture.from(ProdutorEntity.class).gimme(ProdutorEntityTemplate.LOGIN_INCORRETO);

        when(produtorRepository.findByEmailProdutor("teste@hotmail.com")).thenReturn(null);
        agricolabController.validacaoEmail("teste@hotmail.com");
        Assertions.assertThat(agricolabController.validacaoEmail("produtor@hotmail.com")).isEqualTo(false);

    }


    @Test
    public void validacaoTrue(){
        final ProdutorEntity loginProdutor = Fixture.from(ProdutorEntity.class).gimme(ProdutorEntityTemplate.LOGIN_INCORRETO);

        when(produtorRepository.findByEmailProdutor("produtor@hotmail.com")).thenReturn(loginProdutor);
        agricolabController.validacaoEmail("produtor@hotmail.com");
        Assertions.assertThat(agricolabController.validacaoEmail("produtor@hotmail.com")).isEqualTo(true);
    }


}
