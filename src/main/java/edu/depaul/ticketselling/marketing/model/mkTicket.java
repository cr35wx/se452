package edu.depaul.ticketselling.marketing.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tickets")
@Getter
@ToString
public class mkTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id", nullable = false)
    private mkEvent event;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private mkAccount account;

    @Column(nullable = false, length = 255)
    private String seatNumber;

    @Column(nullable = false)
    private int price; // in cents

    public mkTicket() {

    }

    public mkTicket(mkEvent event, String seatNumber, int price) {
        this.event = event;
        this.seatNumber = seatNumber;
        this.price = price;
    }
}