package edu.depaul.ticketselling.management.service;

import edu.depaul.ticketselling.management.model.Venue;
import edu.depaul.ticketselling.management.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService {
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

}
