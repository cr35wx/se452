package edu.depaul.ticketselling.marketing.command;

import java.time.LocalDateTime;

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
    public void execute(String recipient, String eventName, String artistName, LocalDateTime dateTime,
                        String venueName, String venueAddress, int seatNumber, int price) {
        String subject = "Order Confirmation";
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("<html><body>");
        bodyBuilder.append("<p>Order Confirmation</p><br>");
        bodyBuilder.append("<p>Thank you for purchasing tickets. Your Order :</p><br>");
        bodyBuilder.append("<p>Event Name: ").append(eventName).append("</p>");
        bodyBuilder.append("<p>Artist: ").append(artistName).append("</p>");
        bodyBuilder.append("<p>Date and Time: ").append(dateTime).append("</p>");
        bodyBuilder.append("<p>Venue Name: ").append(venueName).append("</p>");
        bodyBuilder.append("<p>Venue Address: ").append(venueAddress).append("</p>");
        bodyBuilder.append("<p>Seat Number: ").append(seatNumber).append("</p>");
        bodyBuilder.append("<p>Price: $").append(price / 100.0).append("</p>");
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
