package br.com.agricolab.repository.mapper;

import br.com.agricolab.domain.Consumidor;
import br.com.agricolab.repository.model.ConsumidorEntity;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
public class ConsumidorEntityMapperTest {

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

        ConsumidorEntity consumidorEntity = new ConsumidorEntity();

        consumidorEntity = ConsumidorEntityMapper.INSTANCE.consumidorToEntity(consumidor);

        Assertions.assertThat(consumidorEntity.getEmailConsumidor()).isEqualTo(consumidor.getEmailConsumidor());
        Assertions.assertThat(consumidorEntity.getCnpjConsumidor()).isEqualTo(consumidor.getCnpjConsumidor());
        Assertions.assertThat(consumidorEntity.getSenhaConsumidor()).isEqualTo(consumidor.getSenhaConsumidor());
        Assertions.assertThat(consumidorEntity.getNomeConsumidor()).isEqualTo(consumidor.getNomeConsumidor());
        Assertions.assertThat(consumidorEntity.getTipoConsumidor()).isEqualTo(consumidor.getTipoConsumidor());
        Assertions.assertThat(consumidorEntity.getLatitudeConsumidor()).isEqualTo(consumidor.getLatitudeConsumidor());
        Assertions.assertThat(consumidorEntity.getLongitudeConsumidor()).isEqualTo(consumidor.getLongitudeConsumidor());
        Assertions.assertThat(consumidorEntity.getEnderecoConsumidor()).isEqualTo(consumidor.getEnderecoConsumidor());
        Assertions.assertThat(consumidorEntity.getIdConsumidor()).isEqualTo(consumidor.getId());
        Assertions.assertThat(consumidorEntity.getTelefoneConsumidor()).isEqualTo(consumidor.getTelefoneConsumidor());
    }

    @Test
    public void successMappingToObject() throws Exception {

        ConsumidorEntity consumidorEntity = new ConsumidorEntity();

        consumidorEntity.setCnpjConsumidor("12334");
        consumidorEntity.setEmailConsumidor("Paulo@gmail.com");
        consumidorEntity.setNomeConsumidor("teste");
        consumidorEntity.setCnpjConsumidor("1223432");
        consumidorEntity.setSenhaConsumidor("5555");
        consumidorEntity.setTipoConsumidor("pj");
        consumidorEntity.setIdConsumidor(12);
        consumidorEntity.setTelefoneConsumidor("444443");
        consumidorEntity.setEnderecoConsumidor("rua dos bobos");
        consumidorEntity.setLatitudeConsumidor(new BigDecimal("12.12"));
        consumidorEntity.setLongitudeConsumidor(new BigDecimal("13.12"));

        Consumidor consumidor;

        consumidor = ConsumidorEntityMapper.INSTANCE.consumidorToEntity(consumidorEntity);

        Assertions.assertThat(consumidorEntity.getEmailConsumidor()).isEqualTo(consumidor.getEmailConsumidor());
        Assertions.assertThat(consumidorEntity.getCnpjConsumidor()).isEqualTo(consumidor.getCnpjConsumidor());
        Assertions.assertThat(consumidorEntity.getSenhaConsumidor()).isEqualTo(consumidor.getSenhaConsumidor());
        Assertions.assertThat(consumidorEntity.getNomeConsumidor()).isEqualTo(consumidor.getNomeConsumidor());
        Assertions.assertThat(consumidorEntity.getTipoConsumidor()).isEqualTo(consumidor.getTipoConsumidor());
        Assertions.assertThat(consumidorEntity.getLatitudeConsumidor()).isEqualTo(consumidor.getLatitudeConsumidor());
        Assertions.assertThat(consumidorEntity.getLongitudeConsumidor()).isEqualTo(consumidor.getLongitudeConsumidor());
        Assertions.assertThat(consumidorEntity.getEnderecoConsumidor()).isEqualTo(consumidor.getEnderecoConsumidor());
        Assertions.assertThat(consumidorEntity.getIdConsumidor()).isEqualTo(consumidor.getId());
        Assertions.assertThat(consumidorEntity.getTelefoneConsumidor()).isEqualTo(consumidor.getTelefoneConsumidor());
    }
}
