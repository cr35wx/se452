package edu.depaul.ticketselling.backend;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IVenueRepository extends CrudRepository<Venue, Long> {
    List<Venue> findVenueByVenueName(String venueName);
    Venue findById(long venueId);
    Venue findVenueByAddressLine1(String addressLine1);
}
