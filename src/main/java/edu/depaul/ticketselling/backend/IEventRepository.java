package edu.depaul.ticketselling.backend;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Interface for generic CRUD operations on a Event repository
 */
public interface IEventRepository extends CrudRepository<Event, Long> {
    Event findByEventName(String eventName);
    List<Event> findByDateTimeBetween(LocalDateTime now, LocalDateTime twentyFourHoursLater);
}
