package br.com.agricolab.core.produtor.mapper;

import br.com.agricolab.core.produtor.dto.ProdutorRequestDto;
import br.com.agricolab.domain.Produtor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Objects;

@Mapper
public interface  ProdutorRequestDtoMapper {
    ProdutorRequestDtoMapper INSTANCE = Mappers.getMapper(ProdutorRequestDtoMapper.class);

    @Mapping(source = "nomeProdutor", target = "nomeProdutor")
    @Mapping(source = "id", target = "idProdutor")
    @Mapping(source = "emailProdutor", target = "emailProdutor")
    @Mapping(source = "cnpjProdutor", target = "cnpjProdutor")
    @Mapping(source = "tipoProdutor", target = "tipoProdutor")
    @Mapping(source = "telefoneProdutor", target = "telefoneProdutor")
    @Mapping(source = "enderecoProdutor", target = "enderecoProdutor")
    @Mapping(source = "complementoEnderecoProdutor", target = "complementoEnderecoProdutor")
    @Mapping(source = "latitudeProdutor", target = "latitudeProdutor")
    @Mapping(source = "longitudeProdutor", target = "longitudeProdutor")
    @Mapping(source = "senhaProdutor", target = "senhaProdutor")
    ProdutorRequestDto produtorToDto(Produtor produtor);

    @InheritInverseConfiguration
    @Mapping(target = "produtos", ignore = true)
    Produtor produtorToDto(ProdutorRequestDto produtor);

    default Produtor updateProdutor(Produtor produtor, Produtor produtorRequest){

        if(!Objects.isNull(produtorRequest.getNomeProdutor()))
            produtor.setNomeProdutor(produtorRequest.getNomeProdutor());

        if(!Objects.isNull(produtorRequest.getCnpjProdutor()))
            produtor.setCnpjProdutor(produtorRequest.getCnpjProdutor());

        if(!Objects.isNull(produtorRequest.getCpfProdutor()))
            produtor.setCpfProdutor(produtorRequest.getCpfProdutor());

        if(!Objects.isNull(produtorRequest.getEmailProdutor()))
            produtor.setEmailProdutor(produtorRequest.getEmailProdutor());

        if(!Objects.isNull(produtorRequest.getTelefoneProdutor()))
            produtor.setTelefoneProdutor(produtorRequest.getTelefoneProdutor());

        if(!Objects.isNull(produtorRequest.getSenhaProdutor()))
            produtor.setSenhaProdutor(produtorRequest.getSenhaProdutor());

        if(!Objects.isNull(produtorRequest.getEnderecoProdutor()))
            produtor.setEnderecoProdutor(produtorRequest.getEnderecoProdutor());

        if(!Objects.isNull(produtorRequest.getTipoProdutor()))
            produtor.setTipoProdutor(produtorRequest.getTipoProdutor());

        if(!Objects.isNull(produtorRequest.getComplementoEnderecoProdutor()))
            produtor.setComplementoEnderecoProdutor(produtorRequest.getComplementoEnderecoProdutor());

        if(!Objects.isNull(produtorRequest.getLatitudeProdutor()))
            produtor.setLatitudeProdutor(produtorRequest.getLatitudeProdutor());

        if(!Objects.isNull(produtorRequest.getLatitudeProdutor()))
            produtor.setLatitudeProdutor(produtorRequest.getLatitudeProdutor());

        return produtor;
    }

}
