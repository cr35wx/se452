package edu.depaul.ticketselling.marketing.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Getter
@Setter
@ToString(exclude = "venue")
public class mEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String name;

    @Column(nullable = false, length = 50)
    private String artist;

    @Column(nullable = false)
    private LocalDateTime datetime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id", nullable = false)
    private mVenue venue;

    public mEvent() {

    }

    public mEvent(String name, String artist, LocalDateTime datetime, mVenue venue) {
        this.name = name;
        this.artist = artist;
        this.datetime = datetime;
        this.venue = venue;
    }
}

