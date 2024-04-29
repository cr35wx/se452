package edu.depaul.ticketselling.management.service;

import edu.depaul.ticketselling.management.model.Event;
import edu.depaul.ticketselling.management.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return StreamSupport.stream(eventRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Event findByName(String name) {
        return eventRepository.findByName(name);
    }

    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> saveAll(List<Event> events) {
        return eventRepository.saveAll(events);
    }

    public Event updateEvent(Long id, Event updatedEvent) {
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

