package edu.depaul.ticketselling.management.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long eventId; // Foreign key to Event
    private String guestId;
    private BigDecimal price;
    private String seatNumber;
    // Other ticket-related fields
}
