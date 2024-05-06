package edu.depaul.ticketselling.marketing.command;

import edu.depaul.ticketselling.management.model.Event;
import edu.depaul.ticketselling.marketing.service.Email;
import edu.depaul.ticketselling.marketing.service.EmailService;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@Component
/**
 * [Marketing and communication]
 * This code is Event cancellations / changes.
 * 
 * This code is currently incomplete. 
 * When the Update code in Management is completed in the future, it will be connected and operated.
 * 
 * @author Suhwan Kim
 */

public class EventChangeNotificationCommand {
    private EmailService emailService;

    public EventChangeNotificationCommand(EmailService emailService) {
        this.emailService = emailService;
    }

    public void execute(String recipient, Event event, boolean isUpdated) {
        if (isUpdated) {
            sendEventUpdateNotification(recipient, event);
        } else {
            sendEventDeletionNotification(recipient, event);
        }
    }
    
    private void sendEventUpdateNotification(String recipient, Event event) {
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
    
    private void sendEventDeletionNotification(String recipient, Event event) {
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
