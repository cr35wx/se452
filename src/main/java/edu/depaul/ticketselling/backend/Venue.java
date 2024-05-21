package edu.depaul.ticketselling.backend;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A {@code Venue} is a location where an {@link Event} is held.
 * <p>
 * Each {@code Venue} has an address, which is built into the class in the fields:
 * [addressLine1, addressLine2, city, state, postalCode].
 * An {@code Address} stores information about the location of a {@code Venue}.
 * <p>
 * An address is formatted as follows:
 * <blockquote><pre>
 * 1 E. Jackson Blvd.
 * Chicago, IL 60604
 * </pre></blockquote>
 * The address may optionally have a second line:
 * <blockquote><pre>
 * 1 E. Jackson Blvd.
 * Suite 205
 * Chicago, IL 60604
 * </pre></blockquote>
 * Venue addresses are assumed to be standard United States addresses. Were this application to be deployed to the public,
 * the address fields would need to be made more robust and adjustable to accept international formats.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "venues")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long venueId;

    @Column(nullable = false, length = 50)
    private String venueName;

    // address fields built in because a nested class was causing too many problems.
    @Column(nullable = false, length = 127)
    private String addressLine1;

    @Column(length = 127)
    private String addressLine2;   // optional

    @Column(nullable = false, length = 63)
    private String city;

    @Column(nullable = false, length = 2)
    private String state;

    @Column(nullable = false, length = 16)
    private String postalCode;

    @Column(nullable = false)
    private long seatingCapacity;

    @Column(columnDefinition = "TEXT")
    private String description;

    /**
     * @return this {@code Venue}'s Address
     */
    public String getAddress() {
        return formatAddress();
    }

    @Override
    public String toString() {
        String address = formatAddress();
        return String.format("%s%n%s%nVenue ID: %d, Seating capacity: %d", venueName, address, venueId, seatingCapacity);
    }

    /**
     * Check if line 2 is null and format accordingly.
     */
    private String formatAddress() {
        if (addressLine2 != null) {
            return String.format("%s%n%s%n%s, %s %s", addressLine1, addressLine2, city, state, postalCode);
        }
        return String.format("%s%n%s, %s %s", addressLine1, city, state, postalCode);
    }

}
