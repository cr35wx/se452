package edu.depaul.ticketselling.marketing.controller;

import edu.depaul.ticketselling.backend.Purchase;

import edu.depaul.ticketselling.marketing.command.OrderConfirmationCommand;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * [Marketing and communication]
 * This code is the Controller of Order Confirmation.
 * 
 * This controller handles the confirmation of orders and sends out confirmation emails to the purchasers.
 * It interacts with the OrderConfirmationCommand to execute the logic for sending confirmation emails.
 * 
 * Upon receiving a request to confirm an order, it retrieves the necessary information from the request body,
 * including the purchased ticket details. It then sends confirmation emails to the purchasers by invoking
 * the execute method of the OrderConfirmationCommand.
 * 
 * @author Suhwan Kim
 */
@RestController
@RequestMapping("/email")
@Component
public class OrderConfirmationController {
    private final OrderConfirmationCommand orderConfirmationCommand;

    @Autowired
    public OrderConfirmationController(OrderConfirmationCommand orderConfirmationCommand) {
        this.orderConfirmationCommand = orderConfirmationCommand;
    }

    @PostMapping("/confirm-order")
    public ResponseEntity<String> confirmOrder(@RequestBody Purchase purchasedTicket) {
        sendOrderConfirmationEmail(purchasedTicket);
        return ResponseEntity.ok("Order confirmation email sent successfully!");
    }

    private void sendOrderConfirmationEmail(Purchase purchase) {
        String recipient = purchase.getAccount().getEmailAddress();

        // Event Data
        String eventName = purchase.getEvent().getEventName();
        String artistName = purchase.getEvent().getArtist().getBandName();
        LocalDateTime dateTime = purchase.getEvent().getDateTime();

        // Venue Data
        String venueName = purchase.getVenue().getVenueName();
        String venueAddress = purchase.getVenue().getAddress();

        // Ticket Data
        int seatNumber = purchase.getTicket().getSeatNumber();
        int price = purchase.getTicket().getPrice();

        orderConfirmationCommand.execute(recipient, eventName, artistName, dateTime, venueName, venueAddress, seatNumber, price);
    }
}
