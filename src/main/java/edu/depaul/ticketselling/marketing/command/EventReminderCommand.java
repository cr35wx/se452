package edu.depaul.ticketselling.marketing.command;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.ticketselling.backend.Event;
import edu.depaul.ticketselling.backend.User;
import edu.depaul.ticketselling.marketing.service.Email;
import edu.depaul.ticketselling.marketing.service.EmailService;

@RestController
@RequestMapping("/email")
@Component
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
}
