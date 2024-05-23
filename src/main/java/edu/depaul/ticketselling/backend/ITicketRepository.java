package edu.depaul.ticketselling.backend;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Interface for generic CRUD operations on a Ticket repository
 */
public interface ITicketRepository extends CrudRepository<Ticket, Long> {
    Ticket findByTicketId(long ticketId);
    Ticket findBySeatNumber(int seatNumber);
    List<Ticket> findByEventEventId(Long eventId);
}
