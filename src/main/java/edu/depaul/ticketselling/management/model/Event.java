package edu.depaul.ticketselling.management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Getter
@ToString(exclude = "venue")
public class Event {

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
    private Venue venue;

    public Event() {

    }

    public Event(String name, String artist, LocalDateTime datetime, Venue venue) {
        this.name = name;
        this.artist = artist;
        this.datetime = datetime;
        this.venue = venue;
    }
}

