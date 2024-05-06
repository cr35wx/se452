package edu.depaul.ticketselling.marketing.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
//import lombok.ToString;

@Entity
@Table(name = "purchases")
@Getter
@Setter
public class mPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    private mTicket ticket;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private mEvent event;

    @ManyToOne
    @JoinColumn(name = "venue_id", referencedColumnName = "id")
    private mVenue venue;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private mAccount account;

    public mPurchase() {
    }

    public mPurchase(mTicket ticket, mEvent event, mVenue venue, mAccount account) {
        this.ticket = ticket;
        this.event = event;
        this.venue = venue;
        this.account = account;
    }
}
