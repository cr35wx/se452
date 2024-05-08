package edu.depaul.ticketselling.marketing.interfaces;

import edu.depaul.ticketselling.marketing.model.mkEvent;

import java.util.List;
import java.util.Optional;

public interface mkIEventService {
    List<mkEvent> getAllEvents();

    mkEvent findByName(String name);

    Optional<mkEvent> findById(Long id);

    mkEvent save(mkEvent event);

    void deleteById(Long id);

    List<mkEvent> saveAll(List<mkEvent> events);

    mkEvent updateEvent(Long id, mkEvent updatedEvent);
}
    
