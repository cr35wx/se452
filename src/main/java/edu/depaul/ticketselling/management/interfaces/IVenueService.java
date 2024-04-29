package edu.depaul.ticketselling.management.interfaces;

import edu.depaul.ticketselling.management.model.Venue;

import java.util.List;
import java.util.Optional;

public interface IVenueService {

    Optional<Venue> findById(Long id);

    Venue findByAddress(String address);

    List<Venue> findAll();

    Venue save(Venue venue);

    List<Venue> saveAll(List<Venue> venues);

    void deleteById(Long id);

    Venue updateVenue(Long id, Venue updatedVenue);
    
}