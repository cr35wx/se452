package edu.depaul.ticketselling.marketing.service;

import edu.depaul.ticketselling.marketing.interfaces.mkIEventService;
import edu.depaul.ticketselling.marketing.model.mkEvent;
import edu.depaul.ticketselling.marketing.repository.mkEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class mkEventService implements mkIEventService {
    private final mkEventRepository eventRepository;

    @Autowired
    public mkEventService(mkEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<mkEvent> getAllEvents() {
        return StreamSupport.stream(eventRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public mkEvent findByName(String name) {
        return eventRepository.findByName(name);
    }

    public Optional<mkEvent> findById(Long id) {
        return eventRepository.findById(id);
    }

    public mkEvent save(mkEvent event) {
        return eventRepository.save(event);
    }

    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    public List<mkEvent> saveAll(List<mkEvent> events) {
        return eventRepository.saveAll(events);
    }

    public mkEvent updateEvent(Long id, mkEvent updatedEvent) {
        return findById(id)
                .map(existingEvent -> {
                    if (updatedEvent.getName() != null) {
                        existingEvent.setName(updatedEvent.getName());
                    }
                    if (updatedEvent.getArtist() != null) {
                        existingEvent.setArtist(updatedEvent.getArtist());
                    }
                    if (updatedEvent.getDatetime() != null) {
                        existingEvent.setDatetime(updatedEvent.getDatetime());
                    }
                    if (updatedEvent.getVenue() != null) {
                        existingEvent.setVenue(updatedEvent.getVenue());
                    }
                    return save(existingEvent);
                })
                .orElse(null); // or throw an exception if necessary
    }
    // Other methods for event management
}

