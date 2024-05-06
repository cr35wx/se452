package edu.depaul.ticketselling.marketing.command;

// !---- connect with backend (Annotation in the event of a backend/management conflict.) ---
// import edu.depaul.ticketselling.backend.Event;
// import edu.depaul.ticketselling.backend.User;
// !-----------------------------------------------------------------------------------------

// !---- marketing mail standalone(Annotation on the release of the app.) -------------------
import edu.depaul.ticketselling.marketing.model.bEvent;
import edu.depaul.ticketselling.marketing.model.bUser;
// !-----------------------------------------------------------------------------------------

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.depaul.ticketselling.marketing.service.Email;
import edu.depaul.ticketselling.marketing.service.EmailService;

/**
 * [Marketing and communication]
 * This code is Event reminders of the E-mail marketing service.
 * 
 * This command is responsible for sending event reminder emails to users.
 * It interacts with the EmailService to send the emails.
 * 
 * Upon execution, it constructs an email containing the details of the upcoming event
 * and sends it to the user as a reminder.
 * 
 * @author Suhwan Kim
 */
@RestController
@RequestMapping("/email")
@Component
public class EventReminderCommand {
    private final EmailService emailService;
    /**
     * Constructor for EventReminderCommand.
     * 
     * @param emailService The service for sending emails.
     */
    public EventReminderCommand(EmailService emailService) {
        this.emailService = emailService;
    }
    // !---- connect with backend (Annotation in the event of a backend/management conflict.) ---
    // /**
    //  * Executes the command to send an event reminder email to a user.
    //  * 
    //  * @param user  The user to whom the reminder email will be sent.
    //  * @param event The event for which the reminder email is sent.
    //  */
    // public void execute(User user, Event event) {
    //     String recipient = user.getEmailAddress();
    //     String subject = "Upcoming Event Reminder";
    //     StringBuilder bodyBuilder = new StringBuilder();
    //     bodyBuilder.append("<html><body>");
    //     bodyBuilder.append("<p>Hello,</p><br>");
    //     bodyBuilder.append("<p>This is a reminder that the event '").append(event.getEventName()).append("' will take place tomorrow. Don't forget to attend!</p><br>");
    //     bodyBuilder.append("<p>Regards,<br>The TicketSelling Team</p>");
    
    //     bodyBuilder.append("</body></html>");
    //     String body = bodyBuilder.toString();
        
    //     Email email = Email.builder()
    //                     .recipient(recipient)
    //                     .subject(subject)
    //                     .body(body)
    //                     .build();
        
    //     emailService.sendEmail(email);
    // }
    // !-----------------------------------------------------------------------------------------

    // !---- marketing mail standalone(Annotation on the release of the app.) -------------------
    /**
     * Executes the command to send an event reminder email to a user.
     * 
     * @param user  The user to whom the reminder email will be sent.
     * @param event The event for which the reminder email is sent.
     */
    public void execute(bUser user, bEvent event) {
        String recipient = user.getEmailAddress();
        String subject = "Upcoming Event Reminder";
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("<html><body>");
        bodyBuilder.append("<p>Hello,</p><br>");
        bodyBuilder.append("<p>This is a reminder that the event '").append(event.getEventName()).append("' will take place tomorrow. Don't forget to attend!</p><br>");
        bodyBuilder.append("<p>Regards,<br>The TicketSelling Team</p>");
    
        bodyBuilder.append("</body></html>");
        String body = bodyBuilder.toString();
        
        Email email = Email.builder()
                        .recipient(recipient)
                        .subject(subject)
                        .body(body)
                        .build();
        
        emailService.sendEmail(email);
    }
    // !-----------------------------------------------------------------------------------------
}
