package edu.depaul.ticketselling.marketing.command;

import java.util.List;

import edu.depaul.ticketselling.backend.Event;
import edu.depaul.ticketselling.backend.Venue;
import edu.depaul.ticketselling.backend.User;
import edu.depaul.ticketselling.backend.IVenueRepository;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.ticketselling.marketing.service.Email;
import edu.depaul.ticketselling.marketing.service.EmailService;


/**
 * [Marketing and communication]
 * This code is the Command of On-Sale Notification.
 * 
 * This command is responsible for generating and sending on-sale notification emails to users.
 * It interacts with the EmailService to send the emails.
 * 
 * It retrieves the list of events and their associated venues from the marketing database repositories.
 * It then constructs the email body containing details of the events, including venue information if available,
 * and sends the email to the user.
 * 
 * Upon successful execution, it sends the on-sale notification emails to users.
 * 
 * @author Suhwan Kim
 */
@RestController
@RequestMapping("/email")
@Component
public class OnSaleNotificationCommand {
    private final EmailService emailService;
    private final IVenueRepository venueRepository;

    /**
     * Constructor for OnSaleNotificationCommand.
     */
    public OnSaleNotificationCommand(EmailService emailService, 
                                     IVenueRepository venueRepository) {
        this.emailService = emailService;
        this.venueRepository = venueRepository;
    }
    
    /**
     * Executes the command to send on-sale notification emails to users.
     * 
     * @param user   The user to whom the email will be sent.
     * @param events The list of events for which on-sale notification emails will be sent.
     */
    public void execute(User user, List<Event> events) {
        String recipient = user.getEmailAddress();
        String subject = "New Events On Sale";
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("<html><body>");
        bodyBuilder.append("<p>Good news! Tickets for the following events are now on sale:</p><br>");
    
        for (Event event : events) {
            bodyBuilder.append("<p>Event: ").append(event.getEventName()).append("</p>");
            bodyBuilder.append("<p>Artist: ").append(event.getArtist()).append("</p>");
            bodyBuilder.append("<p>Date and Time: ").append(event.getDateTime()).append("</p>");
    
            Venue venue = venueRepository.findById(event.getVenue().getVenueId());
            if (venue != null) {
                bodyBuilder.append("<p>Venue: ").append(venue.getVenueName()).append("</p>");
                bodyBuilder.append("<p>Address: ").append(venue.getAddress()).append("</p>");
            }
            bodyBuilder.append("<br>");
        }
    
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
