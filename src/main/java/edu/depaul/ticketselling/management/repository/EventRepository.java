package edu.depaul.ticketselling.management.repository;

import edu.depaul.ticketselling.management.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // Custom queries if needed
    List<Event> findEventsByEventDate(LocalDate eventDate); // or findByEventDate??
    Event findByEventName(String eventName);
}
