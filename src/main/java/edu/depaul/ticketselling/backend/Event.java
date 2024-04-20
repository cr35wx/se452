package edu.depaul.ticketselling.backend;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * An {@code Event} represents a concert, show, lecture, or other performance that takes place in a {@link Venue}.
 */
@Getter
@Setter
@Builder
public class Event {
    @Id
    private long eventId;
    private String eventName;
    private LocalDate date;

}
