package edu.depaul.ticketselling.marketing.command;

import edu.depaul.ticketselling.marketing.model.mkAccount;
import edu.depaul.ticketselling.marketing.model.mkTicket;
import edu.depaul.ticketselling.marketing.service.Email;
import edu.depaul.ticketselling.marketing.service.EmailService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
 * @author [Your Name]
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
     *
     * @param recipient The email address of the recipient.
     * @param event     The event for which the reminder email will be sent.
     */
    public void execute(mkAccount account, mkTicket ticket) {
        String recipient = account.getEmail();
        String subject = "Event Reminder";
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("<html><body>");
        bodyBuilder.append("This is a reminder about a ticket you have purchased:<br/><br/>");
        bodyBuilder.append("Seat Number: " + ticket.getSeatNumber() + "<br/>");
        bodyBuilder.append("Price: $" + (ticket.getPrice() / 100.0) + "<br/><br/>");
        bodyBuilder.append("We hope to see you there!<br/><br/>");
        bodyBuilder.append("Best regards,<br/>");
        bodyBuilder.append("TicketSelling Team");
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