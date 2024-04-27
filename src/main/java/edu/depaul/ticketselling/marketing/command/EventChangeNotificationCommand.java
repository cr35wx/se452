package edu.depaul.ticketselling.marketing.command;

import java.time.LocalDateTime;

import edu.depaul.ticketselling.marketing.service.Email;
import edu.depaul.ticketselling.marketing.service.EmailService;

/**
 * [Marketing and communication]
 * This code is the skeleton of the E-mail marketing service.
 * 
 * Event cancellations / changes
 * 
 * @author Suhwan Kim
 */

public class EventChangeNotificationCommand {
    private EmailService emailService;

    public EventChangeNotificationCommand(EmailService emailService) {
        this.emailService = emailService;
    }

    public void execute(String recipient, String eventName, LocalDateTime newEventDateTime) {
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