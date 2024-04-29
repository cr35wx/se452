package edu.depaul.ticketselling.backend;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

public class VenueService {
    private final IVenueRepository eventRepository;

    @Autowired
    public VenueService(IVenueRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Venue> findAll() {
        return StreamSupport.stream(eventRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Venue> findByName(String venueName) {
        return eventRepository.findVenueByName(venueName);
    }

    public Venue findByAddress(String address) {
        return eventRepository.findVenueByAddress(address);
    }

    public void saveAll(List<Venue> events) {
        eventRepository.saveAll(events);
    }

}
