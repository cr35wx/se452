package edu.depaul.ticketselling.management.service;

import edu.depaul.ticketselling.management.model.Event;
import edu.depaul.ticketselling.management.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
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

    public List<Event> findEventsByEventDate(LocalDate eventDate) {
        return eventRepository.findEventsByEventDate(eventDate);
    }

    public Event findByEventName(String eventName) {
        return eventRepository.findByEventName(eventName);
    }

    public void saveAll(List<Event> events) {
        eventRepository.saveAll(events);
    }

    // Other methods for event management
}
