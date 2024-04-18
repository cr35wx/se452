package edu.depaul.ticketselling.backend;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Data;

/**
 * An {@code Event} represents a concert, show, lecture, or other performance that takes place in a {@link Venue}.
 */
@Data
@Builder
@Table("events")
public class Event {
    @Id
    private long eventId;
    private String eventName;
    private LocalDate date;

}
