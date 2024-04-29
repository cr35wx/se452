package edu.depaul.ticketselling.management.interfaces;

import edu.depaul.ticketselling.management.model.Ticket;

import java.util.List;

public interface ITicketService {

    List<Ticket> findAll();

    Ticket findTicketsByEventId(Long eventId);

    Ticket save(Ticket ticket);

    List<Ticket> saveAll(List<Ticket> tickets);

    Ticket findById(Long id);

    void deleteTicket(Long id);
}
