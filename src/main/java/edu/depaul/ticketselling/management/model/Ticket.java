package edu.depaul.ticketselling.management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tickets")
@Getter
@ToString
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(nullable = false, length = 255)
    private String seatNumber;

    @Column(nullable = false)
    private int price; // in cents

    public Ticket() {

    }

    public Ticket(Event event, String seatNumber, int price) {
        this.event = event;
        this.seatNumber = seatNumber;
        this.price = price;
    }

}
