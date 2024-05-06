package edu.depaul.ticketselling.backend;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ITicketRepository extends CrudRepository<Ticket, Long> {
    Ticket findByTicketId(long ticketId);
    Ticket findBySeatNumber(int seatNumber);
}
