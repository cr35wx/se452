package edu.depaul.ticketselling.backend;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Interface for generic CRUD operations on a Ticket repository.
 *
 * @see Ticket
 */
public interface ITicketRepository extends CrudRepository<Ticket, Long> {
    /**
     * Locate a single ticket by it's ticket ID number.
     * @param ticketId  the ID number
     * @return A ticket with the matching ID.
     */
    Ticket findByTicketId(long ticketId);

    /**
     * Locate a single ticket by it's seat number.
     * @param seatNumber    the seat number to check
     * @return  A ticket with the matching seat number.
     */
    Ticket findBySeatNumber(int seatNumber);

    /**
     * Locate a ticket or list of tickets associated with a given event ID.
     * @param eventId   the event ID to search
     * @return  A list of tickets sold for the matching event ID.
     */
    List<Ticket> findByEventEventId(Long eventId);
}
