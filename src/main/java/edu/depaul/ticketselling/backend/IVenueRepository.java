package edu.depaul.ticketselling.backend;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Interface for generic CRUD operations on a Venue repository.
 *
 * @see Venue
 */
public interface IVenueRepository extends CrudRepository<Venue, Long> {
    /**
     * Locate a venue or list of venues by name.
     * @param venueName the name to search
     * @return Venue(s) with a matching name.
     */
    List<Venue> findVenueByVenueName(String venueName);

    /**
     * Locate a venue by it's venue ID.
     * @param venueId   the ID to locate.
     * @return  A venue with a matching ID.
     */
    Venue findById(long venueId);

    /**
     * Locate a venue by it's address.
     * @param addressLine1  the address to search
     * @return  A venue with a matching address.
     */
    Venue findVenueByAddressLine1(String addressLine1);
}
