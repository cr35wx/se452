package edu.depaul.ticketselling.marketing.command;

import edu.depaul.ticketselling.marketing.model.*;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.ticketselling.marketing.service.Email;
import edu.depaul.ticketselling.marketing.service.EmailService;

/**
 * [Marketing and communication]
 * This code is the Command of Order Confirmation.
 * 
 * This command is responsible for executing the logic to send order confirmation emails to purchasers.
 * It interacts with the EmailService to send out the emails.
 * 
 * Upon execution, it constructs the content of the confirmation email based on the provided recipient
 * and purchased ticket information. It then utilizes the EmailService to send the email.
 * 
 * This function is closely related to the model and repository of management, and may be modified if the management package is modified.
 * 
 * @author Suhwan Kim
 */
@RestController
@RequestMapping("/email")
@Component
public class OrderConfirmationCommand {
    private EmailService emailService;

    /**
     * Constructor for OrderConfirmationCommand.
     * 
     * @param emailService The service responsible for sending emails.
     */
    public OrderConfirmationCommand(EmailService emailService) {
        this.emailService = emailService;
    }

    /**
     * Executes the command to send an order confirmation email.
     * 
     * @param recipient The email address of the recipient.
     * @param ticket    The ticket for which the confirmation email will be sent.
     */
    public void execute(mkTicket ticket) {
        String recipient = ticket.getAccount().getEmail(); // Get recipient email from the ticket's account
        String subject = "Order Confirmation";
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("<html><body>");
        bodyBuilder.append("<p>Order Confirmation</p><br>");
        bodyBuilder.append("<p>Thank you for purchasing tickets. Your Order :</p><br>");
        bodyBuilder.append("<p>Event Name: ").append(ticket.getEvent().getName()).append("</p>");
        bodyBuilder.append("<p>Seat Number: ").append(ticket.getSeatNumber()).append("</p>");
        bodyBuilder.append("<p>Price: $").append(ticket.getPrice() / 100).append("</p>");
        bodyBuilder.append("</body></html>");
        String body = bodyBuilder.toString();

        Email email = Email.builder()
                        .recipient(recipient)
                        .subject(subject)
                        .body(body)
                        .build();

        emailService.sendEmail(email);
    }
}