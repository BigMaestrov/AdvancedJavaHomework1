package ru.bigmaestrov.restapi.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import ru.bigmaestrov.restapi.model.dto.CreateClientDTO;
import ru.bigmaestrov.restapi.model.domain.Client;

@Validated
public interface ClientService {
    String createClient(CreateClientDTO dto);

    String updateClient(String id, CreateClientDTO dto);

    Optional<Client> getClientByID(String id);

    Page<Client> getClients(Pageable pageable);

    Page<Client> getClientsByEmailDomain(String emailDomain, Pageable pageable);

    String removeClientByID(String id);
}
