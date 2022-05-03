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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

        Mockito.when(consumidorService.login(consumidorEntity.getEmailConsumidor(), consumidorEntity.getSenhaConsumidor())).thenReturn(consumidorEntity);

        agricolabController.loginUser(consumidorEntity);

    }

    @Test
    public void LoginCorretoProdutor() throws Exception {

        final ProdutorEntity produtorEntity = Fixture.from(ProdutorEntity.class).gimme(ProdutorEntityTemplate.LOGIN);

        Assertions.assertThat(produtorEntity.getEmailProdutor()).isNotNull();
        Assertions.assertThat(produtorEntity.getSenhaProdutor()).isNotNull();

        Mockito.when(produtorService.login(produtorEntity.getEmailProdutor(), produtorEntity.getSenhaProdutor())).thenReturn(produtorEntity);

        agricolabController.loginProdutor(produtorEntity);

    }

    @Test(expected = Exception.class)
    public void LoginIncorreto() throws Exception {

        final ConsumidorEntity consumidorEntity = Fixture.from(ConsumidorEntity.class).gimme(ConsumidorEntityTemplate.LOGIN);

        Assertions.assertThat(consumidorEntity.getEmailConsumidor()).isNotNull();
        Assertions.assertThat(consumidorEntity.getSenhaConsumidor()).isNotNull();

        Mockito.when(consumidorService.login(consumidorEntity.getEmailConsumidor(), consumidorEntity.getSenhaConsumidor())).thenThrow(Exception.class);

        agricolabController.loginUser(consumidorEntity);

    }


    @Test(expected = Exception.class)
    public void LoginProdutorIncorreto() throws Exception {

        final ProdutorEntity produtorEntity = Fixture.from(ProdutorEntity.class).gimme(ProdutorEntityTemplate.LOGIN);

        Assertions.assertThat(produtorEntity.getEmailProdutor()).isNotNull();
        Assertions.assertThat(produtorEntity.getSenhaProdutor()).isNotNull();

        Mockito.when(produtorService.login(produtorEntity.getEmailProdutor(), produtorEntity.getSenhaProdutor())).thenThrow(Exception.class);

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


}
