package edu.depaul.ticketselling.backend;

import java.time.LocalDateTime;

import edu.depaul.ticketselling.band.Band;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A Ticket is sold to a {@link Customer} and contains details for an {@link Event}.
 * <p>
 * The {@code price} field is stored as an {@code integer} to avoid operations on decimal values. The {@code Ticket} class
 * does not format the price in any way.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tickets")
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketId;

    /**
     * Ticket price in cents. I.E., a price of {@code $15.95} should be stored as {@code 1595}.
     */
    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int seatNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private User account;

    /**
     * @return the Date and Time of this {@code Ticket}'s {@code Event}.
     */
    public LocalDateTime getEventDateTime() {
        return event.getDateTime();
    }

    /**
     * @return the Venue associate with this {@code Ticket}'s {@code Event}.
     */
    public Venue getEventVenue() {
        return event.getVenue();
    }

    /**
     * @return the name of the {@link Event} associated with this {@code Ticket}.
     */
    public String getEventName() {
        return event.getEventName();
    }

    /**
     * @return the artist associated with the {@link Event}.
     */
    public Band getArtist() {
        return event.getArtist();
    }

    /**
     * @return the name of the {@link Venue} associated with this {@code Ticket}'s {@link Event}.
     */
    public String getVenueName() {
        return getEventVenue().getVenueName();
    }

    @Override
    public String toString() {
        return String.format(
                "%s%n%s at %s, seat %d%n%s%n%s%nPrice: $%,.2f\tTicket number: %d",
                event.getEventName(),
                event.getEventDate(),
                event.getEventTime(),
                seatNumber,
                getEventVenue().getVenueName(),
                getEventVenue().getAddress(),
                (float) (price / 100),
                ticketId
        );
    }

}