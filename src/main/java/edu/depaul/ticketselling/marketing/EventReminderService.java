package edu.depaul.ticketselling.marketing;

import java.time.LocalDateTime;

/**
 * [Marketing and communication]
 * This code is the skeleton of the E-mail marketing service.
 * 
 * Event reminders
 * 
 * @author Suhwan Kim
 */
public class EventReminderService {
    private EmailService emailService;

    public EventReminderService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendEventReminderEmail(String recipient, String eventName, LocalDateTime eventDateTime) {
        String subject = "Event Reminder";
        String body = "Reminder: You have an upcoming event " + eventName + " on " + eventDateTime.toString();
        Email email = Email.builder()
                        .recipient(recipient)
                        .subject(subject)
                        .body(body)
                        .build();
        emailService.sendEmail(email);
    }
}