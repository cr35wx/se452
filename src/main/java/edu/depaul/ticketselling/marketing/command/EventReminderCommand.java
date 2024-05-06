package edu.depaul.ticketselling.marketing.command;

import edu.depaul.ticketselling.backend.Event;
import edu.depaul.ticketselling.backend.User;
import edu.depaul.ticketselling.marketing.service.Email;
import edu.depaul.ticketselling.marketing.service.EmailService;

/**
 * [Marketing and communication]
 * This code is Event reminders of the E-mail marketing service.
 * 
 * @author Suhwan Kim
 */
public class EventReminderCommand {
    private final EmailService emailService;

    public EventReminderCommand(EmailService emailService) {
        this.emailService = emailService;
    }

    public void execute(User user, Event event) {
        String recipient = user.getEmailAddress();
        String subject = "Upcoming Event Reminder";
        String body = "Hello,\n\nThis is a reminder that the event '" + event.getEventName() + "' will take place tomorrow. Don't forget to attend!\n\nRegards,\nThe TicketSelling Team";
        
        Email email = Email.builder()
                        .recipient(recipient)
                        .subject(subject)
                        .body(body)
                        .build();
        
        emailService.sendEmail(email);
    }
}
