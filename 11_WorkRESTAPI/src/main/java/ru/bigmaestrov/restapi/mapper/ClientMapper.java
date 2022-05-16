package ru.bigmaestrov.restapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ru.bigmaestrov.restapi.model.domain.Client;
import ru.bigmaestrov.restapi.model.dto.CreateClientDTO;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mapping(target = "birthDate", dateFormat = "yyyy-MM-dd")
    Client createClientDTOToClient(CreateClientDTO createClientDTO);
}
