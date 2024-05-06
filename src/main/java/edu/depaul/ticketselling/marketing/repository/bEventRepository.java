package edu.depaul.ticketselling.marketing.repository;

import org.springframework.data.repository.CrudRepository;
import edu.depaul.ticketselling.marketing.model.bEvent;

public interface bEventRepository extends CrudRepository<bEvent, Long> {
    bEvent findByEventName(String eventName);
}
