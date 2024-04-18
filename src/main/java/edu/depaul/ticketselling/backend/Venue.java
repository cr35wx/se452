package edu.depaul.ticketselling.backend;

import org.springframework.data.annotation.Id;

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
public class Venue {
    @Id
    private long venueId;
    private String venueName;
    private Address address;
    private long seatingCapacity;

    /**
     * An {@code Address} stores information about the location of a {@link Venue}.
     * <p>
     * An address is formatted as follows:
     * <blockquote><pre>
     * 1 E. Jackson Blvd.
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
        private String city;
        private String state;
        private String postalCode;
    }

}
