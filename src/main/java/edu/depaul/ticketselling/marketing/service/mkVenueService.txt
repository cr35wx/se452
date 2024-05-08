package edu.depaul.ticketselling.marketing.service;

import edu.depaul.ticketselling.marketing.interfaces.mkIVenueService;
import edu.depaul.ticketselling.marketing.model.mkVenue;
import edu.depaul.ticketselling.marketing.repository.mkVenueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class mkVenueService implements mkIVenueService {
     private final mkVenueRepository venueRepository;

    @Autowired
    public mkVenueService(mkVenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public Optional<mkVenue> findById(Long id) {
        return venueRepository.findById(id);
    }

    public mkVenue findByAddress(String address) {
        return venueRepository.findByAddressLine1(address);
    }

    public List<mkVenue> findAll() {
        return venueRepository.findAll();
    }
    
    public mkVenue save(mkVenue venue) {
        return venueRepository.save(venue);
    }

    public List<mkVenue> saveAll(List<mkVenue> venues) {
        return venueRepository.saveAll(venues);
    }

    public void deleteById(Long id) {
        venueRepository.deleteById(id);
    }

    public mkVenue updateVenue(Long id, mkVenue updatedVenue) {
        return findById(id)
                .map(existingVenue -> {
                    if (updatedVenue.getName() != null) {
                        existingVenue.setName(updatedVenue.getName());
                    }
                    if (updatedVenue.getPhoneNumber() != null) {
                        existingVenue.setPhoneNumber(updatedVenue.getPhoneNumber());
                    }
                    if (updatedVenue.getEmail() != null) {
                        existingVenue.setEmail(updatedVenue.getEmail());
                    }
                    if (updatedVenue.getCapacity() != null){
                        existingVenue.setCapacity(updatedVenue.getCapacity());
                    }
                    if (updatedVenue.getAddressLine1() != null) {
                        existingVenue.setAddressLine1(updatedVenue.getAddressLine1());
                    }
                    if (updatedVenue.getCity() != null) {
                        existingVenue.setCity(updatedVenue.getCity());
                    }
                    if (updatedVenue.getState() != null) {
                        existingVenue.setState(updatedVenue.getState());
                    }
                    if (updatedVenue.getPostalCode() != null) {
                        existingVenue.setPostalCode(updatedVenue.getPostalCode());
                    }
                    if (updatedVenue.getDescription() != null) {
                        existingVenue.setDescription(updatedVenue.getDescription());
                    }
                    return save(existingVenue);
                })
                .orElseThrow(() -> new NoSuchElementException("Venue not found with id: " + id));
    }
}
