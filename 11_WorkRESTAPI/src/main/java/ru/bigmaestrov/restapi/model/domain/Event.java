package ru.bigmaestrov.restapi.model.domain;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event_table")
public class Event {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "client_id", length = 8, nullable = false)
    private String clientId;
    @Column(name = "event", length = 8, nullable = false)
    private String clientEvent;
    @Column(name = "time", nullable = false)
    private LocalDateTime time;
    
    public Event(String clientId, String clientEvent, LocalDateTime time) {
        this.clientId = clientId;
        this.clientEvent = clientEvent;
        this.time = time;
    }
}
