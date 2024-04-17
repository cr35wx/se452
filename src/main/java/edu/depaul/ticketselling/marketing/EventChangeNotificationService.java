package edu.depaul.ticketselling.marketing;

import java.time.LocalDateTime;

/**
 * [Marketing and communication]
 * This code is the skeleton of the E-mail marketing service.
 * 
 * Event cancellations / changes
 * 
 * @author Suhwan Kim
 */
public class EventChangeNotificationService {
    private EmailService emailService;

    public EventChangeNotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendEventChangeNotificationEmail(String recipient, String eventName, LocalDateTime newEventDateTime) {
        String subject = "Event Change Notification";
        String body = "Please be informed that there has been a change in the schedule for " + eventName + ". The new date and time is " + newEventDateTime.toString();
        Email email = Email.builder()
                        .recipient(recipient)
                        .subject(subject)
                        .body(body)
                        .build();
        emailService.sendEmail(email);
    }
}