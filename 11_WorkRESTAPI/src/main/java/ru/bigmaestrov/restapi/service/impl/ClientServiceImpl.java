package ru.bigmaestrov.restapi.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.bigmaestrov.restapi.event.model.ClientEvent;
import ru.bigmaestrov.restapi.event.publisher.ClientPublisher;
import ru.bigmaestrov.restapi.mapper.ClientMapper;
import ru.bigmaestrov.restapi.model.domain.Client;
import ru.bigmaestrov.restapi.model.domain.Event;
import ru.bigmaestrov.restapi.model.dto.CreateClientDTO;
import ru.bigmaestrov.restapi.repository.ClientRepository;
import ru.bigmaestrov.restapi.repository.EventRepository;
import ru.bigmaestrov.restapi.service.ClientService;

@RequiredArgsConstructor
@Slf4j
@Service
@Validated
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final ClientPublisher publisher;
    private final EventRepository eventRepository;

    @Override
    @Transactional
    public String createClient(CreateClientDTO dto){
        Client client = clientMapper.createClientDTOToClient(dto);
        client.setRegistrationDate(LocalDateTime.now());
        log.info("Object: { }", client);
        clientRepository.save(client);
        eventRepository.save(new Event(client.getId(), ClientEvent.CREATE.toString(), LocalDateTime.now()));
        publisher.publish(ClientEvent.CREATE);
        return "Mapped and Created";
    }

    @Override
    public String updateClient(String id, CreateClientDTO dto) {
        Optional<Client> cOptional = clientRepository.findById(id);
        if(cOptional.isPresent()){
            Client client = cOptional.get();
            Client tempClient = clientMapper.createClientDTOToClient(dto);
            client.setBirthDate((tempClient.getBirthDate() != null)? tempClient.getBirthDate() : client.getBirthDate());
            client.setFirstName((tempClient.getFirstName() != null)? tempClient.getFirstName() : client.getFirstName());
            client.setLastName((tempClient.getLastName() != null)? tempClient.getLastName() : client.getLastName());
            client.setMiddleName((tempClient.getMiddleName() != null)? tempClient.getMiddleName() : client.getMiddleName());
            client.setPhone((tempClient.getPhone() != null)? tempClient.getPhone() : client.getPhone());
            client.setEmail((tempClient.getEmail() != null)? tempClient.getEmail() : client.getEmail());
            client.setGender((tempClient.getGender() != null)? tempClient.getGender() : client.getGender());
            clientRepository.save(client);
            eventRepository.save(new Event(client.getId(), ClientEvent.UPDATE.toString(), LocalDateTime.now()));
            publisher.publish(ClientEvent.UPDATE);
            return "Updated";
        }
        return "Not found";
    }

    @Override
    public Optional<Client> getClientByID(String id) {
        return clientRepository.findById(id);
    }

    @Override
    public Page<Client> getClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public Page<Client> getClientsByEmailDomain(String emailDomain, Pageable pageable) {
        return emailDomain.startsWith("@") ?
            clientRepository.findByEmailContaining(emailDomain, pageable)
            : clientRepository.findByEmailContaining("@" + emailDomain, pageable);
    }

    @Override
    public String removeClientByID(String id) {
        Optional<Client> cOptional = clientRepository.findById(id);
        if(cOptional.isPresent()){
            Client client = cOptional.get();
            client.setDeletionDate(LocalDateTime.now());
            clientRepository.save(client);
            publisher.publish(ClientEvent.DELETE);
            eventRepository.save(new Event(client.getId(), ClientEvent.DELETE.toString(), LocalDateTime.now()));
            return "Deleted";
        }
        return "Not found";
    }
}
