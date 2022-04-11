package br.com.agricolab.core.consumidor.mapper;

import br.com.agricolab.core.consumidor.dto.ConsumidorDto;
import br.com.agricolab.domain.Consumidor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Objects;

@Mapper
public interface ConsumidorDtoMapper {
    ConsumidorDtoMapper INSTANCE = Mappers.getMapper(ConsumidorDtoMapper.class);

    @Mapping(source = "nomeConsumidor", target = "nomeConsumidor")
    @Mapping(source = "id", target = "idConsumidor")
    @Mapping(source = "emailConsumidor", target = "emailConsumidor")
    @Mapping(source = "cnpjConsumidor", target = "cnpjConsumidor")
    @Mapping(source = "tipoConsumidor", target = "tipoConsumidor")
    @Mapping(source = "telefoneConsumidor", target = "telefoneConsumidor")
    @Mapping(source = "enderecoConsumidor", target = "enderecoConsumidor")
    @Mapping(source = "complementoEnderecoConsumidor", target = "complementoEnderecoConsumidor")
    @Mapping(source = "latitudeConsumidor", target = "latitudeConsumidor")
    @Mapping(source = "longitudeConsumidor", target = "longitudeConsumidor")
    @Mapping(source = "senhaConsumidor", target = "senhaConsumidor")
    ConsumidorDto consumidorToDto(Consumidor Consumidor);

    @InheritInverseConfiguration
    Consumidor consumidorToDto(ConsumidorDto Consumidor);

    default Consumidor updateConsumidor(Consumidor Consumidor, Consumidor ConsumidorRequest){

        if(!Objects.isNull(ConsumidorRequest.getNomeConsumidor()))
            Consumidor.setNomeConsumidor(ConsumidorRequest.getNomeConsumidor());

        if(!Objects.isNull(ConsumidorRequest.getCnpjConsumidor()))
            Consumidor.setCnpjConsumidor(ConsumidorRequest.getCnpjConsumidor());

        if(!Objects.isNull(ConsumidorRequest.getCpfConsumidor()))
            Consumidor.setCpfConsumidor(ConsumidorRequest.getCpfConsumidor());

        if(!Objects.isNull(ConsumidorRequest.getEmailConsumidor()))
            Consumidor.setEmailConsumidor(ConsumidorRequest.getEmailConsumidor());

        if(!Objects.isNull(ConsumidorRequest.getTelefoneConsumidor()))
            Consumidor.setTelefoneConsumidor(ConsumidorRequest.getTelefoneConsumidor());

        if(!Objects.isNull(ConsumidorRequest.getSenhaConsumidor()))
            Consumidor.setSenhaConsumidor(ConsumidorRequest.getSenhaConsumidor());

        if(!Objects.isNull(ConsumidorRequest.getEnderecoConsumidor()))
            Consumidor.setEnderecoConsumidor(ConsumidorRequest.getEnderecoConsumidor());

        if(!Objects.isNull(ConsumidorRequest.getTipoConsumidor()))
            Consumidor.setTipoConsumidor(ConsumidorRequest.getTipoConsumidor());

        if(!Objects.isNull(ConsumidorRequest.getComplementoEnderecoConsumidor()))
            Consumidor.setComplementoEnderecoConsumidor(ConsumidorRequest.getComplementoEnderecoConsumidor());

        if(!Objects.isNull(ConsumidorRequest.getLatitudeConsumidor()))
            Consumidor.setLatitudeConsumidor(ConsumidorRequest.getLatitudeConsumidor());

        if(!Objects.isNull(ConsumidorRequest.getLatitudeConsumidor()))
            Consumidor.setLatitudeConsumidor(ConsumidorRequest.getLatitudeConsumidor());

        return Consumidor;
    }

}
