package edu.depaul.ticketselling.backend;

import org.springframework.data.repository.CrudRepository;

public interface IEventRepository extends CrudRepository<Event, Long> {
    Event findByName(String name);
}
