package edu.depaul.ticketselling.backend;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * A {@code Venue} is a location where an {@link Event} is held.
 */
@Getter
@Setter
@Builder
@Entity
@Table("venues")
public class Venue {
    @Id @GeneratedValue(strategy= GenerationType.AUTO) private long venueId;
    private String venueName;
    private Address address;
    private long seatingCapacity;

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
        private String line1;
        private String line2;   // optional
        private String city;
        private String state;
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
