package edu.depaul.ticketselling.marketing.command;

import edu.depaul.ticketselling.backend.Event;
import edu.depaul.ticketselling.backend.User;
import edu.depaul.ticketselling.marketing.service.Email;
import edu.depaul.ticketselling.marketing.service.EmailService;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * [Marketing and communication]
 * This code is Event cancellations / changes.
 * 
 * This command is responsible for executing notifications related to event cancellations or changes.
 * It interacts with the EmailService to send out the notifications.
 * 
 * Upon execution, it determines whether the event has been updated or deleted based on the provided flag.
 * It constructs the appropriate notification email content and utilizes the EmailService to send the email.
 * 
 * This function is closely related to the model and repository of management, and may be modified if the management package is modified.
 * 
 * @author Suhwan Kim
 */
@RestController
@RequestMapping("/email")
@Component
public class EventCancelNotificationCommand {
    private final EmailService emailService;

    /**
     * Constructor for EventChangeNotificationCommand.
     * 
     * @param emailService The service responsible for sending emails.
     */
    public EventCancelNotificationCommand(EmailService emailService) {
        this.emailService = emailService;
    }

    /**
     * Sends a notification for event updates.
     * 
     * @param recipient The email address of the recipient.
     * @param event     The updated event information.
     */
    public void execute(User user, Event event) {
        String recipient = user.getEmailAddress();
        String subject = "Event Cancellation Notification";
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("<html><body>");
        bodyBuilder.append("<p>Please be informed that the event ").append(event.getEventName()).append(" has been cancelled.</p>");
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