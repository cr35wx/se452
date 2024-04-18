package edu.depaul.ticketselling.management.service;

import edu.depaul.ticketselling.management.model.Ticket;
import edu.depaul.ticketselling.management.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public List<Ticket> findTicketsByEventId(Long eventId) {
        return ticketRepository.findTicketsByEventId(eventId);
    }

    public void saveAll(List<Ticket> tickets) {
        ticketRepository.saveAll(tickets);
    }

    // Implement ticket-related methods
}

