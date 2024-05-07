package edu.depaul.ticketselling.management.service;

import edu.depaul.ticketselling.backend.Event;
import edu.depaul.ticketselling.backend.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EventService {
//public class EventService implements IEventService {
    private final IEventRepository eventRepository;

    @Autowired
    public EventService(IEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findAllEvents() {
        return StreamSupport.stream(eventRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Event findByName(String name) {
        return eventRepository.findByEventName(name);
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
        eventRepository.saveAll(events);
        return events;
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        return findById(id)
                .map(existingEvent -> {
                    if (updatedEvent.getEventName() != null) {
                        existingEvent.setEventName(updatedEvent.getEventName());
                    }
                    if (updatedEvent.getArtist() != null) {
                        existingEvent.setArtist(updatedEvent.getArtist());
                    }
                    if (updatedEvent.getDateTime() != null) {
                        existingEvent.setDateTime(updatedEvent.getDateTime());
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

