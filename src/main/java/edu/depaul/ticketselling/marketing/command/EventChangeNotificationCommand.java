package edu.depaul.ticketselling.marketing.command;

import edu.depaul.ticketselling.marketing.model.*;
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
public class EventChangeNotificationCommand {
    private final EmailService emailService;

    /**
     * Constructor for EventChangeNotificationCommand.
     * 
     * @param emailService The service responsible for sending emails.
     */
    public EventChangeNotificationCommand(EmailService emailService) {
        this.emailService = emailService;
    }

    /**
     * Sends a notification for event updates.
     * 
     * @param recipient The email address of the recipient.
     * @param event     The updated event information.
     * @param isUpdated A flag indicating if the event has been updated.
     */
    public void sendEventChangeNotification(String recipient, mkEvent event, boolean isUpdated) {
        if (isUpdated) {
            sendEventUpdateNotification(recipient, event);
        } else {
            sendEventDeletionNotification(recipient, event);
        }
    }
    
    /**
     * Sends a notification for event updates.
     * 
     * @param recipient The email address of the recipient.
     * @param event     The updated event information.
     */
    private void sendEventUpdateNotification(String recipient, mkEvent event) {
        String subject = "Event Change Notification";
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("<html><body>");
        bodyBuilder.append("<p>Your Event is Updated!</p><br>");
        bodyBuilder.append("<p>Please be informed that there has been an update in the schedule for ").append(event.getName()).append(".</p><br>");
        bodyBuilder.append("<p>Updated Event Information:</p><br>");
        bodyBuilder.append("<p>Event Name: ").append(event.getName()).append("</p>");
        bodyBuilder.append("<p>Artist: ").append(event.getArtist()).append("</p>");
        bodyBuilder.append("<p>Date and Time: ").append(event.getDatetime()).append("</p>");
        bodyBuilder.append("<p>Venue: ").append(event.getVenue().getName()).append("</p>");
        bodyBuilder.append("<p>Address: ").append(event.getVenue().getAddressLine1()).append(", ")
                .append(event.getVenue().getAddressLine2()).append(", ").append(event.getVenue().getCity()).append(", ")
                .append(event.getVenue().getState()).append(", ").append(event.getVenue().getPostalCode()).append("</p>");
    
        bodyBuilder.append("</body></html>");
        String body = bodyBuilder.toString();
    
        Email email = Email.builder()
                .recipient(recipient)
                .subject(subject)
                .body(body)
                .build();
    
        emailService.sendEmail(email);
    }
    
    /**
     * Sends a notification for event deletions.
     * 
     * @param recipient The email address of the recipient.
     * @param event     The event that has been deleted.
     */
    public void sendEventDeletionNotification(String recipient, mkEvent event) {
        String subject = "Event Deletion Notification";
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("<html><body>");
        bodyBuilder.append("<p>Please be informed that the event ").append(event.getName()).append(" has been deleted.</p>");
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
