package edu.depaul.ticketselling.backend;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

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
    @Id
    private long ticketId;
    private int price;
    private int seatNumber;
    private Event event;
    private LocalDate date;
    private Venue venue;

}