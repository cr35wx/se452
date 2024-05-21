package edu.depaul.ticketselling.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a User's {@code Purchase} or the item(s) in their "shopping cart"
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "purchases")
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticketId")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "eventId")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "venue_id", referencedColumnName = "venueId")
    private Venue venue;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User account;

}
