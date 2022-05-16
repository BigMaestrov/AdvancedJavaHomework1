package ru.bigmaestrov.restapi.event.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.bigmaestrov.restapi.event.model.ClientEvent;
import ru.bigmaestrov.restapi.event.model.ClientSpringEvent;

@RequiredArgsConstructor
@Slf4j
@Component
public class ClientPublisher {
    private final ApplicationEventPublisher publisher;

    public void publish(ClientEvent event) {
        ClientSpringEvent clientSpringEvent = new ClientSpringEvent(this, event);
        publisher.publishEvent(clientSpringEvent);
    }
}
