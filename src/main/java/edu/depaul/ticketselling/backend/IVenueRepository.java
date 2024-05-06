package edu.depaul.ticketselling.backend;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IVenueRepository extends CrudRepository<Venue, Long> {
    List<Venue> findVenueByName(String name);
    Venue findVenueByAddress(String address);
    Venue findVenueByAddress(String addressLine1, String addressLine2);
    Venue findVenueByAddress(Venue.Address address);
}
