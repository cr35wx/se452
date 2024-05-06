package edu.depaul.ticketselling.marketing.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import edu.depaul.ticketselling.marketing.model.bVenue;

public interface bVenueRepository extends CrudRepository<bVenue, Long> {
    List<bVenue> findVenueByVenueName(String venueName);
    bVenue findById(long venueId);
    bVenue findVenueByAddressLine1(String addressLine1);
}
