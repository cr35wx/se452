package edu.depaul.ticketselling.backend;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IPurchaseRepository extends CrudRepository<Purchase, Long> {

    // Need to Check. Suhwan Kim Added.
    List<Purchase> findByEvent(Event updatedEvent);
}
