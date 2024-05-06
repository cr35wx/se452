package edu.depaul.ticketselling.backend;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {
    private final IVenueRepository venueRepository;

    @Autowired
    public VenueService(IVenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public List<Venue> findAll() {
        return StreamSupport.stream(venueRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Venue> findByName(String venueName) {
        return venueRepository.findVenueByVenueName(venueName);
    }

    public Venue findByVenueId(long venueId) {
        return venueRepository.findById(venueId);
    }

    public void saveAll(List<Venue> events) {
        venueRepository.saveAll(events);
    }

}
