package br.com.agricolab.repository.mapper;

import br.com.agricolab.domain.Produtor;
import br.com.agricolab.repository.model.ProdutorEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface ProdutorEntityMapper {
    ProdutorEntityMapper INSTANCE = Mappers.getMapper(ProdutorEntityMapper.class);

    @Mapping(source = "nomeProdutor", target = "nomeProdutor")
    @Mapping(source = "id", target = "idProdutor")
    @Mapping(source = "emailProdutor", target = "emailProdutor")
    @Mapping(source = "cnpjProdutor", target = "cnpjProdutor")
    @Mapping(source = "tipoProdutor", target = "tipoProdutor")
    @Mapping(source = "cpfProdutor", target = "cpfProdutor")
    @Mapping(source = "telefoneProdutor", target = "telefoneProdutor")
    @Mapping(source = "enderecoProdutor", target = "enderecoProdutor")
    @Mapping(source = "complementoEnderecoProdutor", target = "complementoEnderecoProdutor")
    @Mapping(source = "latitudeProdutor", target = "latitudeProdutor")
    @Mapping(source = "longitudeProdutor", target = "longitudeProdutor")
    @Mapping(target = "produtos",ignore = true)
    ProdutorEntity produtorToEntity(Produtor produtor);

    @InheritInverseConfiguration
    @Mapping(target = "produtos",ignore = true)
    Produtor produtorToEntity(ProdutorEntity produtor);

}
