package edu.depaul.ticketselling.management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@ToString
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long eventId; // Foreign key to Event
    private Long guestId;
    private BigDecimal price;
    private String seatNumber;

    public Ticket() {

    }

    public Ticket(Long eventId, Long guestId, BigDecimal price, String seatNumber) {
        this.eventId = eventId;
        this.guestId = guestId;
        this.price = price;
        this.seatNumber = seatNumber;
    }


    // Other ticket-related fields
}
