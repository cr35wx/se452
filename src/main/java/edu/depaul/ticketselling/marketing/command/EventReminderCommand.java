package edu.depaul.ticketselling.marketing.command;

import java.time.LocalDateTime;

import edu.depaul.ticketselling.marketing.service.Email;
import edu.depaul.ticketselling.marketing.service.EmailService;

/**
 * [Marketing and communication]
 * This code is the skeleton of the E-mail marketing service.
 * 
 * Event reminders
 * 
 * @author Suhwan Kim
 */

public class EventReminderCommand {
    private EmailService emailService;

    public EventReminderCommand(EmailService emailService) {
        this.emailService = emailService;
    }

    public void execute(String recipient, String eventName, LocalDateTime eventDateTime) {
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