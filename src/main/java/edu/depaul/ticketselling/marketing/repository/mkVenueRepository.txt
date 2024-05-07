package edu.depaul.ticketselling.marketing.repository;

import edu.depaul.ticketselling.marketing.model.mkVenue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface mkVenueRepository extends JpaRepository<mkVenue, Long> {
    mkVenue findByAddressLine1(String address);
}
