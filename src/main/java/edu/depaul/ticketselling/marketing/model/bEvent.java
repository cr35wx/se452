package edu.depaul.ticketselling.marketing.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An {@code Event} represents a concert, show, lecture, or other performance that takes place in a {@link bVenue}.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "events")
public class bEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eventId;

    @Column(nullable = false, length = 50, unique = true)
    private String eventName;

    @Column(nullable = false, length = 50)
    private String artist;

    @Column(nullable = false, name = "date_time")
    private LocalDateTime dateTime;

    @OneToMany(mappedBy = "event")
    private List<UserEvent> userEvents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id", nullable = false)
    private bVenue venue;

    /**
     * @return the {@code Address} field of this {@code Event}'s {@code Venue}.
     */
    public String getVenueAddress() {
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
