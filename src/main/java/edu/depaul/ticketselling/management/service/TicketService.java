package edu.depaul.ticketselling.management.service;

import edu.depaul.ticketselling.management.interfaces.ITicketService;
import edu.depaul.ticketselling.management.model.Event;
import edu.depaul.ticketselling.management.model.Purchase;
import edu.depaul.ticketselling.management.model.Ticket;
import edu.depaul.ticketselling.management.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements ITicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Ticket findTicketsByEventId(Long eventId) {
        return ticketRepository.findById(eventId).orElse(null);
    }

    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> saveAll(List<Ticket> tickets) {
        return ticketRepository.saveAll(tickets);
    }

   public Ticket findById(Long id) {
        Optional<Ticket> Ticket = ticketRepository.findById(id);
        return Ticket.orElse(null);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

}

