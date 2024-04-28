package edu.depaul.ticketselling.management.repository;

import edu.depaul.ticketselling.management.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
    Venue findByAddressLine1(String address);
}
