package ru.bigmaestrov.restapi.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.util.Streamable;

import ru.bigmaestrov.restapi.model.domain.Client;

public interface ClientRepository extends PagingAndSortingRepository<Client, String> {
    Streamable<Client> findAll();
    Optional<Client> findById(String id);
    Page<Client> findByEmailContaining(String email, Pageable pageable);
}
