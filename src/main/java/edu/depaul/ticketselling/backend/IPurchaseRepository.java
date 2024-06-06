package edu.depaul.ticketselling.backend;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Interface for generic CRUD operations on a Purchase repository.
 *
 * @see Purchase
 */
public interface IPurchaseRepository extends CrudRepository<Purchase, Long> {

    // Need to Check. Suhwan Kim Added.
    /**
     * Locate all purchases for a given event.
     * @param updatedEvent
     * @return  A list of purchases
     */
    List<Purchase> findByEvent(Event updatedEvent);
}
