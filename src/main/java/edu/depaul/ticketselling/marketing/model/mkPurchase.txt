package edu.depaul.ticketselling.marketing.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "purchases")
@Getter
@Setter
public class mkPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    private mkTicket ticket;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private mkEvent event;

    @ManyToOne
    @JoinColumn(name = "venue_id", referencedColumnName = "id")
    private mkVenue venue;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private mkAccount account;

    public mkPurchase() {
    }

    public mkPurchase(mkTicket ticket, mkEvent event, mkVenue venue, mkAccount account) {
        this.ticket = ticket;
        this.event = event;
        this.venue = venue;
        this.account = account;
    }
}
