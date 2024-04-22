package edu.depaul.ticketselling.management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "events")
@Getter
@Setter
@ToString
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventName;
    private LocalDate eventDate;
    // Other event-related fields

    public Event() {

    }

    public Event(long id, String eventName, LocalDate eventDate) {
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;
    }
}

