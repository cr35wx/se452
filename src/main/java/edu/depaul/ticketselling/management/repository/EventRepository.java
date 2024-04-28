package edu.depaul.ticketselling.management.repository;

import edu.depaul.ticketselling.management.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Event findByName(String name);
}
