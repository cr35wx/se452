package edu.depaul.ticketselling.marketing.controller;

import edu.depaul.ticketselling.marketing.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.ticketselling.marketing.command.OrderConfirmationCommand;

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
 * This function is closely related to the model and repository of management, and may be modified if the management package is modified.
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
    public ResponseEntity<String> confirmOrder(@RequestBody mkTicket purchasedTicket) {
        orderConfirmationCommand.execute(purchasedTicket);
        return ResponseEntity.ok("Order confirmation email sent successfully!");
    }
}
