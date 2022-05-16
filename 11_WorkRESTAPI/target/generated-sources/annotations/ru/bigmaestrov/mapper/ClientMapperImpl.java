package ru.bigmaestrov.restapi.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.bigmaestrov.restapi.model.domain.Client;
import ru.bigmaestrov.restapi.model.domain.Gender;
import ru.bigmaestrov.restapi.model.dto.CreateClientDTO;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2022-05-16T12:16:19+0400",
        comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.2 (Eclipse Adoptium)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client createClientDTOToClient(CreateClientDTO createClientDTO) {
        if ( createClientDTO == null ) {
            return null;
        }

        Client client = new Client();

        if ( createClientDTO.getBirthDate() != null ) {
            client.setBirthDate( LocalDate.parse( createClientDTO.getBirthDate(), DateTimeFormatter.ofPattern( "yyyy-MM-dd" ) ) );
        }
        client.setEmail( createClientDTO.getEmail() );
        client.setFirstName( createClientDTO.getFirstName() );
        if ( createClientDTO.getGender() != null ) {
            client.setGender( Enum.valueOf( Gender.class, createClientDTO.getGender() ) );
        }
        client.setId( createClientDTO.getId() );
        client.setLastName( createClientDTO.getLastName() );
        client.setMiddleName( createClientDTO.getMiddleName() );
        client.setPhone( createClientDTO.getPhone() );

        return client;
    }
}
