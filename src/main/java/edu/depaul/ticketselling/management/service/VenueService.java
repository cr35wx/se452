package edu.depaul.ticketselling.management.service;

import edu.depaul.ticketselling.management.interfaces.IVenueService;
import edu.depaul.ticketselling.management.model.Venue;
import edu.depaul.ticketselling.management.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VenueService implements IVenueService {
    private final VenueRepository venueRepository;

    @Autowired
    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public Optional<Venue> findById(Long id) {
        return venueRepository.findById(id);
    }

    public Venue findByAddress(String address) {
        return venueRepository.findByAddressLine1(address);
    }

    public List<Venue> findAll() {
        return venueRepository.findAll();
    }
    
    public Venue save(Venue venue) {
        return venueRepository.save(venue);
    }

    public List<Venue> saveAll(List<Venue> venues) {
        return venueRepository.saveAll(venues);
    }

    public void deleteById(Long id) {
        venueRepository.deleteById(id);
    }

    public Venue updateVenue(Long id, Venue updatedVenue) {
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
