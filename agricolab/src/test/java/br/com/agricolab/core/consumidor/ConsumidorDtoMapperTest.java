package br.com.agricolab.core.consumidor;

import br.com.agricolab.core.consumidor.dto.ConsumidorDto;
import br.com.agricolab.core.consumidor.mapper.ConsumidorDtoMapper;
import br.com.agricolab.domain.Consumidor;
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

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
public class ConsumidorDtoMapperTest {

    @Test
    public void successMappingToDto() throws Exception {

        Consumidor consumidor = new Consumidor();

        consumidor.setCnpjConsumidor("12334");
        consumidor.setEmailConsumidor("Paulo@gmail.com");
        consumidor.setNomeConsumidor("teste");
        consumidor.setCnpjConsumidor("1223432");
        consumidor.setSenhaConsumidor("5555");
        consumidor.setTipoConsumidor("pj");
        consumidor.setId(12);
        consumidor.setTelefoneConsumidor("444443");
        consumidor.setEnderecoConsumidor("rua dos bobos");
        consumidor.setLatitudeConsumidor(new BigDecimal("12.12"));
        consumidor.setLongitudeConsumidor(new BigDecimal("13.12"));

        ConsumidorDto consumidorDto = new ConsumidorDto();

        consumidorDto = ConsumidorDtoMapper.INSTANCE.consumidorToDto(consumidor);

        Assertions.assertThat(consumidorDto.getEmailConsumidor()).isEqualTo(consumidor.getEmailConsumidor());
        Assertions.assertThat(consumidorDto.getCnpjConsumidor()).isEqualTo(consumidor.getCnpjConsumidor());
        Assertions.assertThat(consumidorDto.getSenhaConsumidor()).isEqualTo(consumidor.getSenhaConsumidor());
        Assertions.assertThat(consumidorDto.getNomeConsumidor()).isEqualTo(consumidor.getNomeConsumidor());
        Assertions.assertThat(consumidorDto.getTipoConsumidor()).isEqualTo(consumidor.getTipoConsumidor());
        Assertions.assertThat(consumidorDto.getLatitudeConsumidor()).isEqualTo(consumidor.getLatitudeConsumidor());
        Assertions.assertThat(consumidorDto.getLongitudeConsumidor()).isEqualTo(consumidor.getLongitudeConsumidor());
        Assertions.assertThat(consumidorDto.getEnderecoConsumidor()).isEqualTo(consumidor.getEnderecoConsumidor());
        Assertions.assertThat(consumidorDto.getIdConsumidor()).isEqualTo(consumidor.getId().toString());
        Assertions.assertThat(consumidorDto.getTelefoneConsumidor()).isEqualTo(consumidor.getTelefoneConsumidor());
    }

    @Test
    public void successMappingToObject() throws Exception {

        ConsumidorDto consumidorDto = new ConsumidorDto();

        consumidorDto.setCnpjConsumidor("12334");
        consumidorDto.setEmailConsumidor("Paulo@gmail.com");
        consumidorDto.setNomeConsumidor("teste");
        consumidorDto.setCnpjConsumidor("1223432");
        consumidorDto.setSenhaConsumidor("5555");
        consumidorDto.setTipoConsumidor("pj");
        consumidorDto.setIdConsumidor("12");
        consumidorDto.setTelefoneConsumidor("444443");
        consumidorDto.setEnderecoConsumidor("rua dos bobos");
        consumidorDto.setLatitudeConsumidor(new BigDecimal("12.12"));
        consumidorDto.setLongitudeConsumidor(new BigDecimal("13.12"));

        Consumidor consumidor;

        consumidor = ConsumidorDtoMapper.INSTANCE.consumidorToDto(consumidorDto);

        Assertions.assertThat(consumidorDto.getEmailConsumidor()).isEqualTo(consumidor.getEmailConsumidor());
        Assertions.assertThat(consumidorDto.getCnpjConsumidor()).isEqualTo(consumidor.getCnpjConsumidor());
        Assertions.assertThat(consumidorDto.getSenhaConsumidor()).isEqualTo(consumidor.getSenhaConsumidor());
        Assertions.assertThat(consumidorDto.getNomeConsumidor()).isEqualTo(consumidor.getNomeConsumidor());
        Assertions.assertThat(consumidorDto.getTipoConsumidor()).isEqualTo(consumidor.getTipoConsumidor());
        Assertions.assertThat(consumidorDto.getLatitudeConsumidor()).isEqualTo(consumidor.getLatitudeConsumidor());
        Assertions.assertThat(consumidorDto.getLongitudeConsumidor()).isEqualTo(consumidor.getLongitudeConsumidor());
        Assertions.assertThat(consumidorDto.getEnderecoConsumidor()).isEqualTo(consumidor.getEnderecoConsumidor());
        Assertions.assertThat(consumidorDto.getIdConsumidor()).isEqualTo(consumidor.getId().toString());
        Assertions.assertThat(consumidorDto.getTelefoneConsumidor()).isEqualTo(consumidor.getTelefoneConsumidor());
    }
}
