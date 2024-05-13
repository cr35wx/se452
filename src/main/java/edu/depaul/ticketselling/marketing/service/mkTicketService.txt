package edu.depaul.ticketselling.marketing.service;

import edu.depaul.ticketselling.marketing.interfaces.mkITicketService;
import edu.depaul.ticketselling.marketing.model.mkTicket;
import edu.depaul.ticketselling.marketing.repository.mkTicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class mkTicketService implements mkITicketService {
    private final mkTicketRepository ticketRepository;

    @Autowired
    public mkTicketService(mkTicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<mkTicket> findAll() {
        return ticketRepository.findAll();
    }

    public mkTicket findTicketsByEventId(Long eventId) {
        return ticketRepository.findById(eventId).orElse(null);
    }

    public mkTicket save(mkTicket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<mkTicket> saveAll(List<mkTicket> tickets) {
        return ticketRepository.saveAll(tickets);
    }

   public mkTicket findById(Long id) {
        Optional<mkTicket> Ticket = ticketRepository.findById(id);
        return Ticket.orElse(null);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

}

