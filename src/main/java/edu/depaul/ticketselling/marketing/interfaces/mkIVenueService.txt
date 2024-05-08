package edu.depaul.ticketselling.marketing.interfaces;

import edu.depaul.ticketselling.marketing.model.mkVenue;

import java.util.List;
import java.util.Optional;

public interface mkIVenueService {
    Optional<mkVenue> findById(Long id);

    mkVenue findByAddress(String address);

    List<mkVenue> findAll();

    mkVenue save(mkVenue venue);

    List<mkVenue> saveAll(List<mkVenue> venues);

    void deleteById(Long id);

    mkVenue updateVenue(Long id, mkVenue updatedVenue);
    
}
