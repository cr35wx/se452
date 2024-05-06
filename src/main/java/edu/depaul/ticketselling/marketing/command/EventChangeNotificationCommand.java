package edu.depaul.ticketselling.marketing.command;

import edu.depaul.ticketselling.management.model.Event;
import edu.depaul.ticketselling.marketing.service.Email;
import edu.depaul.ticketselling.marketing.service.EmailService;

/**
 * [Marketing and communication]
 * This code is Event cancellations / changes.
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
        bodyBuilder.append("Your Event is Updated!:\n");
        bodyBuilder.append("Please be informed that there has been an update in the schedule for ").append(event.getName()).append(".\n\n");
        bodyBuilder.append("Updated Event Information:\n");
        bodyBuilder.append("Event Name: ").append(event.getName()).append("\n");
        bodyBuilder.append("Artist: ").append(event.getArtist()).append("\n");
        bodyBuilder.append("Date and Time: ").append(event.getDatetime()).append("\n");
        bodyBuilder.append("Venue: ").append(event.getVenue().getName()).append("\n");
        bodyBuilder.append("Address: ").append(event.getVenue().getAddressLine1()).append(", ")
                .append(event.getVenue().getAddressLine2()).append(", ").append(event.getVenue().getCity()).append(", ")
                .append(event.getVenue().getState()).append(", ").append(event.getVenue().getPostalCode()).append("\n");
    
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
        String body = "Please be informed that the event " + event.getName() + " has been deleted.";
        Email email = Email.builder()
                .recipient(recipient)
                .subject(subject)
                .body(body)
                .build();
        emailService.sendEmail(email);
    }
}
