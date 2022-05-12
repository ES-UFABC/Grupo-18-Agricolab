package br.com.agricolab.repository.mapper;

import br.com.agricolab.domain.Consumidor;
import br.com.agricolab.repository.model.ConsumidorEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface ConsumidorEntityMapper {
    ConsumidorEntityMapper INSTANCE = Mappers.getMapper(ConsumidorEntityMapper.class);

    @Mapping(source = "nomeConsumidor", target = "nomeConsumidor")
    @Mapping(source = "id", target = "idConsumidor")
    @Mapping(source = "emailConsumidor", target = "emailConsumidor")
    @Mapping(source = "cnpjConsumidor", target = "cnpjConsumidor")
    @Mapping(source = "tipoConsumidor", target = "tipoConsumidor")
    @Mapping(source = "cpfConsumidor", target = "cpfConsumidor")
    @Mapping(source = "telefoneConsumidor", target = "telefoneConsumidor")
    @Mapping(source = "enderecoConsumidor", target = "enderecoConsumidor")
    @Mapping(source = "complementoEnderecoConsumidor", target = "complementoEnderecoConsumidor")
    @Mapping(source = "latitudeConsumidor", target = "latitudeConsumidor")
    @Mapping(source = "longitudeConsumidor", target = "longitudeConsumidor")
    ConsumidorEntity consumidorToEntity(Consumidor consumidor);

    @InheritInverseConfiguration
    Consumidor consumidorToEntity(ConsumidorEntity consumidor);

}
