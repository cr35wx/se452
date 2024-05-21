package edu.depaul.ticketselling.backend;

import org.springframework.data.repository.CrudRepository;

public interface IEventRepository extends CrudRepository<Event, Long> {
    Event findByEventName(String eventName);
    List<Event> findByDateTimeBetween(LocalDateTime now, LocalDateTime twentyFourHoursLater);
}
