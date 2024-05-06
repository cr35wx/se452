package edu.depaul.ticketselling.marketing.command;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.ticketselling.management.model.Ticket;
import edu.depaul.ticketselling.marketing.service.Email;
import edu.depaul.ticketselling.marketing.service.EmailService;

@RestController
@RequestMapping("/email")
@Component
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
        bodyBuilder.append("<html><body>");
        bodyBuilder.append("<p>Order Confirmation</p><br>");
        bodyBuilder.append("<p>Thank you for purchasing tickets. Your Order :</p><br>");
        bodyBuilder.append("<p>Event Id: ").append(ticket.getEvent()).append("</p>");
        bodyBuilder.append("<p>Seat Number: ").append(ticket.getSeatNumber()).append("</p>");
        bodyBuilder.append("<p>Price: ").append(ticket.getPrice() / 100).append("</p>");
    
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
