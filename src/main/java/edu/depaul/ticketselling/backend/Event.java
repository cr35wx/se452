package edu.depaul.ticketselling.backend;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

/**
 * An {@code Event} represents a concert, show, lecture, or other performance that takes place in a {@link Venue}.
 */
@Data
@Builder
@Entity
@Table("events")
public class Event {
    @Id @GeneratedValue(strategy= GenerationType.AUTO) private long eventId;
    private String eventName;
    private String artist;
    private LocalDateTime dateTime;
    private Venue venue;

    /**
     * @return the {@code Address} field of this {@code Event}'s {@code Venue}.
     */
    public Venue.Address getVenueAddress() {
        return venue.getAddress();
    }

    /**
     * Gets the {@code LocalDate} part of the {@code dateTime} field.
     * This returns a {@code LocalDate} with the same year, month and day as that field.
     * @return the date part of the {@code Event} date-time
     */
    public LocalDate getEventDate() {
        return dateTime.toLocalDate();
    }

    /**
     * Gets the {@code LocalTime} part of the {@code dateTime} field.
     * This returns a LocalTime with the same hour, minute, second and nanosecond as that field.
     * @return the time part of the {@code Event} date-time
     */
    public LocalTime getEventTime() {
        return dateTime.toLocalTime();
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s at %s%n%s%n%s", eventName, artist, getEventDate(), getEventTime(), venue.getVenueName(), getVenueAddress());
    }

}
