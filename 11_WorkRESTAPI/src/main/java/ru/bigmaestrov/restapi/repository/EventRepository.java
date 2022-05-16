package ru.bigmaestrov.restapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import ru.bigmaestrov.restapi.model.domain.Event;

public interface EventRepository extends PagingAndSortingRepository<Event, Long>{
    
}
