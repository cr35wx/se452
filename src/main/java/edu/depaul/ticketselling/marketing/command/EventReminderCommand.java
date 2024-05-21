package edu.depaul.ticketselling.marketing.command;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.ticketselling.backend.Purchase;
import edu.depaul.ticketselling.marketing.service.Email;
import edu.depaul.ticketselling.marketing.service.EmailService;

/**
 * [Marketing and communication]
 * This code is the Command of Event Reminder.
 *
 * This command is responsible for executing the logic to send event reminder emails to purchasers.
 * It interacts with the EmailService to send out the emails.
 *
 * Upon execution, it constructs the content of the event reminder email based on the provided event
 * information. It then utilizes the EmailService to send the email.
 *
 * @author Suhwan Kim
 */
@RestController
@RequestMapping("/email")
@Component
public class EventReminderCommand {
    private final EmailService emailService;

    /**
     * Constructor for EventReminderCommand.
     *
     * @param emailService The service responsible for sending emails.
     */
    public EventReminderCommand(EmailService emailService) {
        this.emailService = emailService;
    }

    /**
     * Executes the command to send an event reminder email.
     */
    public void execute(Purchase purchase) {
        String subject = "Upcoming Event Reminder";
        String recipient = purchase.getAccount().getEmailAddress();
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("<html><body>");
        bodyBuilder.append("<p>This is a reminder that the event will take place tomorrow.</p><br><br>");
        bodyBuilder.append("<p>Event: ").append(purchase.getEvent().getEventName()).append("</p>");
        bodyBuilder.append("<p>Artist: ").append(purchase.getEvent().getArtist()).append("</p>");
        bodyBuilder.append("<p>Date and Time: ").append(purchase.getEvent().getDateTime()).append("</p>");
        bodyBuilder.append("<p>Event Venue: ").append(purchase.getEvent().getVenueName()).append("</p>");
        bodyBuilder.append("<p>Your Seat: ").append(purchase.getTicket().getSeatNumber()).append("</p>");
        bodyBuilder.append("<br>");
        bodyBuilder.append("<p>Don't forget to attend!<br><br>Regards,<br>The TicketSelling Team</p>");
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
