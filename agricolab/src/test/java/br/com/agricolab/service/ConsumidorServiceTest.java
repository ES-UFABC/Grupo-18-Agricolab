package br.com.agricolab.service;

import br.com.agricolab.repository.adapter.ConsumidorRepository;
import br.com.agricolab.repository.model.ConsumidorEntity;
import br.com.agricolab.templates.ConsumidorEntityTemplate;
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
public class ConsumidorServiceTest {

    @Mock
    ConsumidorRepository consumidorRepository;

    @InjectMocks
    ConsumidorService consumidorService;

    @Before
    public void setup(){
        FixtureFactoryLoader.loadTemplates("br.com.agricolab.templates");


    }


    @Test
    public void deveLogar() throws Exception {
        final ConsumidorEntity consumidorEntity = Fixture.from(ConsumidorEntity.class).gimme(ConsumidorEntityTemplate.LOGIN);

        Mockito.when(consumidorRepository.findByEmailConsumidorAndSenhaConsumidor("teste@hotmail.com", "senhateste")).thenReturn(consumidorEntity);

        Assertions.assertThat("teste@hotmail.com").isEqualTo(consumidorEntity.getEmailConsumidor());

        Assertions.assertThat("senhateste").isEqualTo(consumidorEntity.getSenhaConsumidor());

        Assertions.assertThat(consumidorService.login("teste@hotmail.com","senhateste" )).isEqualTo(consumidorEntity);


    }

    @Test(expected = Exception.class)
    public void naoDeveLogar() throws Exception {
        final ConsumidorEntity consumidorEntity = Fixture.from(ConsumidorEntity.class).gimme(ConsumidorEntityTemplate.LOGIN);

        Mockito.when(consumidorRepository.findByEmailConsumidorAndSenhaConsumidor("teste@hotmail.com", "senha")).thenReturn(null);


        Assertions.assertThat(consumidorService.login("teste@hotmail.com","senhateste" )).isEqualTo(Exception.class);

    }
}
