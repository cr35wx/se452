package edu.depaul.ticketselling.backend;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * A {@code Venue} is a location where an {@link Event} is held.
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "venues")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long venueId;

    @Column(nullable = false, length = 50)
    private String venueName;

    @Column(nullable = false)
    private Address address;

    @Column(nullable = false)
    private long seatingCapacity;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Override
    public String toString() {
        return String.format("%s%n%s%nVenue ID: %d, Seating capacity: %d", venueName, address, venueId, seatingCapacity);
    }

    /**
     * An {@code Address} stores information about the location of a {@link Venue}.
     * <p>
     * An address is formatted as follows:
     * <blockquote><pre>
     * 1 E. Jackson Blvd.
     * Chicago, IL 60604
     * </pre></blockquote>
     * An address may optionally have a second line:
     * <blockquote><pre>
     * 1 E. Jackson Blvd.
     * Suite 205
     * Chicago, IL 60604
     * </pre></blockquote>
     * Addresses are assumed to be standard United States addresses.
     */
    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class Address {
        @Column(nullable = false, length = 100)
        private String line1;

        @Column(length = 100)
        private String line2;   // optional

        @Column(nullable = false, length = 50)
        private String city;

        @Column(nullable = false, length = 2)
        private String state;

        @Column(nullable = false, length = 16)
        private String postalCode;

        @Override
        public String toString() {
            if (!(line2 == null)) {
                return String.format("%s%n%s%n%s, %s %s", line1, line2, city, state, postalCode);
            }
            return String.format("%s%n%s, %s %s", line1, city, state, postalCode);
        }
    }

}
