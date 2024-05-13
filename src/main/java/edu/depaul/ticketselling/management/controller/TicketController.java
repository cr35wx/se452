package edu.depaul.ticketselling.management.controller;

import edu.depaul.ticketselling.backend.Purchase;
import edu.depaul.ticketselling.backend.Ticket;
import edu.depaul.ticketselling.management.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
         List<Ticket> Tickets = ticketService.findAll();
        return ResponseEntity.ok(Tickets);
    }

    @GetMapping("/{eventId}")
    public List<Ticket> getTicketsByEventId(@PathVariable Long eventId) {
        return ticketService.findTicketsByEventId(eventId);
    }

    @PostMapping("/purchase")
    public ResponseEntity<Ticket> purchaseTicket(@RequestBody Ticket ticket) {
        Ticket purchasedTicket = ticketService.save(ticket);
        return new ResponseEntity<>(purchasedTicket, HttpStatus.CREATED);
    }

    @PostMapping("/cancel/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Add more endpoints as needed
}
