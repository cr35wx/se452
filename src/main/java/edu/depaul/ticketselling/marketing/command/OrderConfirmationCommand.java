package edu.depaul.ticketselling.marketing.command;

import edu.depaul.ticketselling.management.model.Ticket;
import edu.depaul.ticketselling.marketing.service.Email;
import edu.depaul.ticketselling.marketing.service.EmailService;

/**
 * [Marketing and communication]
 * This code is the Command of Order Confirmation.
 * 
 * @author Suhwan Kim
 */
public class OrderConfirmationCommand {
    private EmailService emailService;

    public OrderConfirmationCommand(EmailService emailService) {
        this.emailService = emailService;
    }

    public void execute(String recipient, Ticket ticket) {
        String subject = "Order Confirmation";
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("Order Confirmation\n\n");
        bodyBuilder.append("Thank you for purchasing tickets. Your Order : \n");
        bodyBuilder.append("Event Id: ").append(ticket.getEvent()).append("\n");
        bodyBuilder.append("Seat Number: ").append(ticket.getSeatNumber()).append("\n");
        bodyBuilder.append("Price: ").append(ticket.getPrice() / 100).append("\n");

        String body = bodyBuilder.toString();
        
        Email email = Email.builder()
                        .recipient(recipient)
                        .subject(subject)
                        .body(body)
                        .build();
        
        emailService.sendEmail(email);
    }

}
