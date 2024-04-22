package edu.depaul.ticketselling.backend;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;

/**
 * A Ticket is sold to a {@link Customer} and contains details for an {@link Event}.
 * <p>
 * The {@code price} field is stored as an {@code integer} to avoid operations on decimal values. The {@code Ticket} class
 * does not format the price in any way.
 */
@Data
@Builder
@Table("tickets")
public class Ticket {
    @Id @GeneratedValue(strategy= GenerationType.AUTO) private long ticketId;
    private int price;
    private int seatNumber;
    private Event event;

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