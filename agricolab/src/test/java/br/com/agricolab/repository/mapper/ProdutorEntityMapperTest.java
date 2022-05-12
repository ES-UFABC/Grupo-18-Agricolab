package br.com.agricolab.repository.mapper;

import br.com.agricolab.core.produtor.dto.ProdutorDto;
import br.com.agricolab.core.produtor.mapper.ProdutorDtoMapper;
import br.com.agricolab.domain.Produtor;
import br.com.agricolab.repository.model.ProdutorEntity;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProdutorEntityMapperTest {

    @Test
    public void successMappingToDto() throws Exception {

        Produtor produtor = new Produtor();

        produtor.setCnpjProdutor("12334");
        produtor.setEmailProdutor("Paulo@gmail.com");
        produtor.setNomeProdutor("teste");
        produtor.setCnpjProdutor("1223432");
        produtor.setSenhaProdutor("5555");
        produtor.setTipoProdutor("pj");
        produtor.setId(12);
        produtor.setTelefoneProdutor("444443");
        produtor.setEnderecoProdutor("rua dos bobos");
        produtor.setLatitudeProdutor(new BigDecimal("12.12"));
        produtor.setLongitudeProdutor(new BigDecimal("13.12"));

        ProdutorEntity produtorEntity = new ProdutorEntity();

        produtorEntity = ProdutorEntityMapper.INSTANCE.produtorToEntity(produtor);

        Assertions.assertThat(produtorEntity.getEmailProdutor()).isEqualTo(produtor.getEmailProdutor());
        Assertions.assertThat(produtorEntity.getCnpjProdutor()).isEqualTo(produtor.getCnpjProdutor());
        Assertions.assertThat(produtorEntity.getSenhaProdutor()).isEqualTo(produtor.getSenhaProdutor());
        Assertions.assertThat(produtorEntity.getNomeProdutor()).isEqualTo(produtor.getNomeProdutor());
        Assertions.assertThat(produtorEntity.getTipoProdutor()).isEqualTo(produtor.getTipoProdutor());
        Assertions.assertThat(produtorEntity.getLatitudeProdutor()).isEqualTo(produtor.getLatitudeProdutor());
        Assertions.assertThat(produtorEntity.getLongitudeProdutor()).isEqualTo(produtor.getLongitudeProdutor());
        Assertions.assertThat(produtorEntity.getEnderecoProdutor()).isEqualTo(produtor.getEnderecoProdutor());
        Assertions.assertThat(produtorEntity.getIdProdutor()).isEqualTo(produtor.getId());
        Assertions.assertThat(produtorEntity.getTelefoneProdutor()).isEqualTo(produtor.getTelefoneProdutor());
    }

    @Test
    public void successMappingToObject() throws Exception {

        ProdutorEntity produtorEntity = new ProdutorEntity();

        produtorEntity.setCnpjProdutor("12334");
        produtorEntity.setEmailProdutor("Paulo@gmail.com");
        produtorEntity.setNomeProdutor("teste");
        produtorEntity.setCnpjProdutor("1223432");
        produtorEntity.setSenhaProdutor("5555");
        produtorEntity.setTipoProdutor("pj");
        produtorEntity.setIdProdutor(12);
        produtorEntity.setTelefoneProdutor("444443");
        produtorEntity.setEnderecoProdutor("rua dos bobos");
        produtorEntity.setLatitudeProdutor(new BigDecimal("12.12"));
        produtorEntity.setLongitudeProdutor(new BigDecimal("13.12"));

        Produtor produtor;

        produtor = ProdutorEntityMapper.INSTANCE.produtorToEntity(produtorEntity);

        Assertions.assertThat(produtorEntity.getEmailProdutor()).isEqualTo(produtor.getEmailProdutor());
        Assertions.assertThat(produtorEntity.getCnpjProdutor()).isEqualTo(produtor.getCnpjProdutor());
        Assertions.assertThat(produtorEntity.getSenhaProdutor()).isEqualTo(produtor.getSenhaProdutor());
        Assertions.assertThat(produtorEntity.getNomeProdutor()).isEqualTo(produtor.getNomeProdutor());
        Assertions.assertThat(produtorEntity.getTipoProdutor()).isEqualTo(produtor.getTipoProdutor());
        Assertions.assertThat(produtorEntity.getLatitudeProdutor()).isEqualTo(produtor.getLatitudeProdutor());
        Assertions.assertThat(produtorEntity.getLongitudeProdutor()).isEqualTo(produtor.getLongitudeProdutor());
        Assertions.assertThat(produtorEntity.getEnderecoProdutor()).isEqualTo(produtor.getEnderecoProdutor());
        Assertions.assertThat(produtorEntity.getIdProdutor()).isEqualTo(produtor.getId());
        Assertions.assertThat(produtorEntity.getTelefoneProdutor()).isEqualTo(produtor.getTelefoneProdutor());
    }
}
