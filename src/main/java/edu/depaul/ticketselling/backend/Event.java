package edu.depaul.ticketselling.backend;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.depaul.ticketselling.band.Band;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An {@code Event} represents a concert, show, lecture, or other performance that takes place in a {@link Venue}.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Builder
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eventId;

    @Column(nullable = false, length = 50, unique = true)
    private String eventName;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_id", nullable = false)
    private Band artist;

    @Column(nullable = false, name = "date_time")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "venue_id", nullable = false)
    private Venue venue;

    /**
     * @return the Address of this {@code Event}'s {@code Venue}.
     */
    public String getVenueAddress() {
        return venue.getAddress();
    }

    /**
     * @return the name of the {@link Venue} associated with this {@code Event}
     */
    public String getVenueName() {
        return venue.getVenueName();
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
        return String.format("%s%n%s%n%s at %s%n%s%n%s",
                eventName,
                artist.toString(),
                getEventDate(),
                getEventTime(),
                getVenueName(),
                getVenueAddress());
    }

}
