package edu.depaul.ticketselling.management.controller;

import edu.depaul.ticketselling.management.model.Purchase;
import edu.depaul.ticketselling.management.model.Ticket;
import edu.depaul.ticketselling.management.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
* The contents were added and modified for the implementation of marketing functions (May 5 2024)
* src/main/java/edu/depaul/ticketselling/marketing/controller/OrderConfirmationController.java
*
* Please check the annotated comment.
* @author Suhwan Kim
*/
import java.util.List;
import edu.depaul.ticketselling.marketing.controller.OrderConfirmationController; // Added by Suhwan.

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final OrderConfirmationController orderConfirmationController; // Added by Suhwan.

    @Autowired
    public TicketController(TicketService ticketService, OrderConfirmationController orderConfirmationController) { // Modified by Suhwan.
        this.ticketService = ticketService;
        this.orderConfirmationController = orderConfirmationController; // Added by Suhwan.
    }

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
    public Ticket getTicketsByEventId(@PathVariable Long eventId) {
        return ticketService.findTicketsByEventId(eventId);
    }

    @PostMapping("/purchase")
    public ResponseEntity<Ticket> purchaseTicket(@RequestBody Ticket ticket) {
        Ticket purchasedTicket = ticketService.save(ticket);
        orderConfirmationController.confirmOrder(purchasedTicket); // Added by Suhwan.
        return new ResponseEntity<>(purchasedTicket, HttpStatus.CREATED);
    }

    @PostMapping("/cancel/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Add more endpoints as needed
}
