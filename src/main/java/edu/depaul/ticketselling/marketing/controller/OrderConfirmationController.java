package edu.depaul.ticketselling.marketing.controller;

import java.util.List;

// !---- connect with management (Annotation in the event of a backend/management conflict.) ---
// import edu.depaul.ticketselling.management.model.Ticket;
// import edu.depaul.ticketselling.management.repository.AccountRepository;
// !--------------------------------------------------------------------------------------------

// !---- connect with management (Annotation in the event of a backend/management conflict.) ---
import edu.depaul.ticketselling.marketing.model.mTicket;
import edu.depaul.ticketselling.marketing.repository.mAccountRepository;
// !--------------------------------------------------------------------------------------------

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
 * @author Suhwan Kim
 */
@RestController
@RequestMapping("/email")
@Component
public class OrderConfirmationController {
    private final OrderConfirmationCommand orderConfirmationCommand;
    // !---- connect with management (Annotation in the event of a backend/management conflict.) ---
    // private final AccountRepository accountRepository;

    // /**
    //  * Constructor for OrderConfirmationController.
    //  * 
    //  * @param orderConfirmationCommand The command responsible for sending order confirmation emails.
    //  * @param accountRepository        The repository for managing user accounts.
    //  */
    // @Autowired
    // public OrderConfirmationController(OrderConfirmationCommand orderConfirmationCommand, 
    //                                     AccountRepository accountRepository) {
    //     this.orderConfirmationCommand = orderConfirmationCommand;
    //     this.accountRepository = accountRepository;
    // }

    // /**
    //  * Endpoint to confirm an order and send confirmation emails.
    //  * 
    //  * @param purchasedTicket The ticket that has been purchased and requires confirmation.
    //  * @return                ResponseEntity indicating the status of the confirmation email sending process.
    //  */
    // @PostMapping("/confirm-order")
    // public ResponseEntity<String> confirmOrder(@RequestBody Ticket purchasedTicket) {
    //     sendOrderConfirmationEmail(purchasedTicket);
    //     return ResponseEntity.ok("Order confirmation email sent successfully!");
    // }

    // /**
    //  * Sends order confirmation emails to the purchasers.
    //  * 
    //  * @param ticket The purchased ticket for which the confirmation email will be sent.
    //  */
    // private void sendOrderConfirmationEmail(Ticket ticket) {
    //     List<String> recipientEmails = accountRepository.getEmailsByTicketId(ticket.getId());
    //     for (String recipient : recipientEmails) {
    //         orderConfirmationCommand.execute(recipient, ticket);
    //     }
    // }
    // !--------------------------------------------------------------------------------------------

    // !---- connect with management (Annotation in the event of a backend/management conflict.) ---
    private final mAccountRepository accountRepository;

    /**
     * Constructor for OrderConfirmationController.
     * 
     * @param orderConfirmationCommand The command responsible for sending order confirmation emails.
     * @param accountRepository        The repository for managing user accounts.
     */
    @Autowired
    public OrderConfirmationController(OrderConfirmationCommand orderConfirmationCommand, 
                                        mAccountRepository accountRepository) {
        this.orderConfirmationCommand = orderConfirmationCommand;
        this.accountRepository = accountRepository;
    }

    /**
     * Endpoint to confirm an order and send confirmation emails.
     * 
     * @param purchasedTicket The ticket that has been purchased and requires confirmation.
     * @return                ResponseEntity indicating the status of the confirmation email sending process.
     */
    @PostMapping("/confirm-order")
    public ResponseEntity<String> confirmOrder(@RequestBody mTicket purchasedTicket) {
        sendOrderConfirmationEmail(purchasedTicket);
        return ResponseEntity.ok("Order confirmation email sent successfully!");
    }

    /**
     * Sends order confirmation emails to the purchasers.
     * 
     * @param ticket The purchased ticket for which the confirmation email will be sent.
     */
    private void sendOrderConfirmationEmail(mTicket ticket) {
        List<String> recipientEmails = accountRepository.getEmailsByTicketId(ticket.getId());
        for (String recipient : recipientEmails) {
            orderConfirmationCommand.execute(recipient, ticket);
        }
    }
    // !--------------------------------------------------------------------------------------------
}
