package edu.depaul.ticketselling.backend;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Interface for generic CRUD operations on a Event repository.
 *
 * @see Event
 */
public interface IEventRepository extends CrudRepository<Event, Long> {
    /**
     * Locate a single event with a matching name.
     * @param eventName the name of the event to search for
     * @return An Event with a matching name.
     */
    Event findByEventName(String eventName);

    /**
     * Locate an event or series of events that are scheduled in the next 24 hours.
     * @param now
     * @param twentyFourHoursLater
     * @return A list of events in the next 24 hours.
     */
    List<Event> findByDateTimeBetween(LocalDateTime now, LocalDateTime twentyFourHoursLater);
}
