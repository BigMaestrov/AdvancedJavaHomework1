package ru.bigmaestrov.restapi.controller.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Sort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.bigmaestrov.restapi.controller.ClientController;
import ru.bigmaestrov.restapi.model.domain.Client;
import ru.bigmaestrov.restapi.model.dto.CreateClientDTO;
import ru.bigmaestrov.restapi.service.ClientService;

@RequiredArgsConstructor
@Slf4j
@RestController
public class ClientConrollerImpl implements ClientController {
    private final ClientService service;

    @Override
    public ResponseEntity<String> createClient(CreateClientDTO dto) {
        log.info("Received object: { }", dto);
        String client = service.createClient(dto);
        return ResponseEntity.ok(client);
    }

    @Override
    public ResponseEntity<String> updateClient(String id, CreateClientDTO dto) {
        log.info("Received object: { }", dto);
        String client = service.updateClient(id, dto);
        return ResponseEntity.ok(client);
    }

    @Override
    public ResponseEntity<Page<Client>> getClients(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Client> clients = service.getClients(pageRequest);
        return ResponseEntity.ok(clients);
    }

    @Override
    public ResponseEntity<Client> getClientByID(String id) {
        return ResponseEntity.of(service.getClientByID(id));
    }

    @Override
    public ResponseEntity<Page<Client>> getClientsByEmailDomain(String emailDomain, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Client> clients = service.getClientsByEmailDomain(emailDomain, pageRequest);
        return ResponseEntity.ok(clients);
    }

    @Override
    public ResponseEntity<Page<Client>> getClientsByLastNameByOrder(Integer page, Integer size) {
        Sort sort = Sort.by(Sort.Order.asc("lastName"));
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Client> clients = service.getClients(pageRequest);
        return ResponseEntity.ok(clients);
    }

    @Override
    public ResponseEntity<String> removeClient(String id){
        return ResponseEntity.ok(service.removeClientByID(id));
    }
}
