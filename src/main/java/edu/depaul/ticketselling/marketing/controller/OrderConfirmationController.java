package edu.depaul.ticketselling.marketing.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.depaul.ticketselling.marketing.command.OrderConfirmationCommand;
import edu.depaul.ticketselling.management.model.Ticket;
import edu.depaul.ticketselling.management.repository.AccountRepository;

@RestController
@RequestMapping("/email")
@Component
/**
 * [Marketing and communication]
 * This code is the Controller of Order Confirmation.
 * 
 * @author Suhwan Kim
 */
public class OrderConfirmationController {
    private final OrderConfirmationCommand orderConfirmationCommand;
    private final AccountRepository accountRepository;

    @Autowired
    public OrderConfirmationController(OrderConfirmationCommand orderConfirmationCommand, 
                                        AccountRepository accountRepository) {
        this.orderConfirmationCommand = orderConfirmationCommand;
        this.accountRepository = accountRepository;
    }

    @PostMapping("/confirm-order")
    public ResponseEntity<String> confirmOrder(@RequestBody Ticket purchasedTicket) {
        sendOrderConfirmationEmail(purchasedTicket);
        return ResponseEntity.ok("Order confirmation email sent successfully!");
    }

    private void sendOrderConfirmationEmail(Ticket ticket) {
        List<String> recipientEmails = accountRepository.getEmailsByTicketId(ticket.getId());
        for (String recipient : recipientEmails) {
            orderConfirmationCommand.execute(recipient, ticket);
        }
    }
}
