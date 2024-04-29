package edu.depaul.ticketselling.management.interfaces;

import edu.depaul.ticketselling.management.model.Event;

import java.util.List;
import java.util.Optional;

public interface IEventService {

    List<Event> getAllEvents();

    Event findByName(String name);

    Optional<Event> findById(Long id);

    Event save(Event event);

    void deleteById(Long id);

    List<Event> saveAll(List<Event> events);

    Event updateEvent(Long id, Event updatedEvent);
}
    
