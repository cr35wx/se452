package edu.depaul.ticketselling.management.service;

//import edu.depaul.ticketselling.management.interfaces.ITicketService;
import edu.depaul.ticketselling.backend.Ticket;
import edu.depaul.ticketselling.backend.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TicketService {
//public class TicketService implements ITicketService
    private final ITicketRepository ticketRepository;

    @Autowired
    public TicketService(ITicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> findAll() {
        return StreamSupport.stream(ticketRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Ticket> findTicketsByEventId(Long eventId) {
        return ticketRepository.findByEventEventId(eventId);
    }

    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> saveAll(List<Ticket> tickets) {
        ticketRepository.saveAll(tickets);
        return tickets;
    }

   public Ticket findById(Long id) {
       return ticketRepository.findById(id).orElse(null);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

}

