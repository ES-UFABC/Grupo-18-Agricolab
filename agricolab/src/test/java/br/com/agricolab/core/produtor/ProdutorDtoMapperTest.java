package br.com.agricolab.core.produtor;

import br.com.agricolab.core.produtor.dto.ProdutorDto;
import br.com.agricolab.core.produtor.mapper.ProdutorDtoMapper;
import br.com.agricolab.domain.Produtor;
import br.com.agricolab.domain.Produtor;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProdutorDtoMapperTest {

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

        ProdutorDto produtorDto = new ProdutorDto();

        produtorDto = ProdutorDtoMapper.INSTANCE.produtorToDto(produtor);

        Assertions.assertThat(produtorDto.getEmailProdutor()).isEqualTo(produtor.getEmailProdutor());
        Assertions.assertThat(produtorDto.getCnpjProdutor()).isEqualTo(produtor.getCnpjProdutor());
        Assertions.assertThat(produtorDto.getSenhaProdutor()).isEqualTo(produtor.getSenhaProdutor());
        Assertions.assertThat(produtorDto.getNomeProdutor()).isEqualTo(produtor.getNomeProdutor());
        Assertions.assertThat(produtorDto.getTipoProdutor()).isEqualTo(produtor.getTipoProdutor());
        Assertions.assertThat(produtorDto.getLatitudeProdutor()).isEqualTo(produtor.getLatitudeProdutor());
        Assertions.assertThat(produtorDto.getLongitudeProdutor()).isEqualTo(produtor.getLongitudeProdutor());
        Assertions.assertThat(produtorDto.getEnderecoProdutor()).isEqualTo(produtor.getEnderecoProdutor());
        Assertions.assertThat(produtorDto.getIdProdutor()).isEqualTo(produtor.getId().toString());
        Assertions.assertThat(produtorDto.getTelefoneProdutor()).isEqualTo(produtor.getTelefoneProdutor());
    }

    @Test
    public void successMappingToObject() throws Exception {

        ProdutorDto produtorDto = new ProdutorDto();

        produtorDto.setCnpjProdutor("12334");
        produtorDto.setEmailProdutor("Paulo@gmail.com");
        produtorDto.setNomeProdutor("teste");
        produtorDto.setCnpjProdutor("1223432");
        produtorDto.setSenhaProdutor("5555");
        produtorDto.setTipoProdutor("pj");
        produtorDto.setIdProdutor("12");
        produtorDto.setTelefoneProdutor("444443");
        produtorDto.setEnderecoProdutor("rua dos bobos");
        produtorDto.setLatitudeProdutor(new BigDecimal("12.12"));
        produtorDto.setLongitudeProdutor(new BigDecimal("13.12"));

        Produtor produtor;

        produtor = ProdutorDtoMapper.INSTANCE.produtorToDto(produtorDto);

        Assertions.assertThat(produtorDto.getEmailProdutor()).isEqualTo(produtor.getEmailProdutor());
        Assertions.assertThat(produtorDto.getCnpjProdutor()).isEqualTo(produtor.getCnpjProdutor());
        Assertions.assertThat(produtorDto.getSenhaProdutor()).isEqualTo(produtor.getSenhaProdutor());
        Assertions.assertThat(produtorDto.getNomeProdutor()).isEqualTo(produtor.getNomeProdutor());
        Assertions.assertThat(produtorDto.getTipoProdutor()).isEqualTo(produtor.getTipoProdutor());
        Assertions.assertThat(produtorDto.getLatitudeProdutor()).isEqualTo(produtor.getLatitudeProdutor());
        Assertions.assertThat(produtorDto.getLongitudeProdutor()).isEqualTo(produtor.getLongitudeProdutor());
        Assertions.assertThat(produtorDto.getEnderecoProdutor()).isEqualTo(produtor.getEnderecoProdutor());
        Assertions.assertThat(produtorDto.getIdProdutor()).isEqualTo(produtor.getId().toString());
        Assertions.assertThat(produtorDto.getTelefoneProdutor()).isEqualTo(produtor.getTelefoneProdutor());
    }
}
