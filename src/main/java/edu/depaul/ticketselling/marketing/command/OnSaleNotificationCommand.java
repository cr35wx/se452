package edu.depaul.ticketselling.marketing.command;

import java.util.List;
import edu.depaul.ticketselling.marketing.service.Email;
import edu.depaul.ticketselling.marketing.service.EmailService;
import edu.depaul.ticketselling.backend.Event;
import edu.depaul.ticketselling.backend.Venue;
import edu.depaul.ticketselling.backend.User;
import edu.depaul.ticketselling.backend.IVenueRepository;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@Component
/**
 * [Marketing and communication]
 * This code is the Command of On Sale Notification.
 * 
 * @author Suhwan Kim
 */
public class OnSaleNotificationCommand {
    private final EmailService emailService;
    private final IVenueRepository venueRepository;

    public OnSaleNotificationCommand(EmailService emailService, IVenueRepository venueRepository) {
        this.emailService = emailService;
        this.venueRepository = venueRepository;
    }
    
    public void execute(User user, List<Event> events) {
        String recipient = user.getEmailAddress();
        String subject = "New Events On Sale";
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("Good news! Tickets for the following events are now on sale:\n\n");

        for (Event event : events) {
            bodyBuilder.append("Event: ").append(event.getEventName()).append("\n");
            bodyBuilder.append("Artist: ").append(event.getArtist()).append("\n");
            bodyBuilder.append("Date and Time: ").append(event.getDateTime()).append("\n");

            Venue venue = venueRepository.findById(event.getVenue().getVenueId()).orElse(null);
            if (venue != null) {
                bodyBuilder.append("Venue: ").append(venue.getVenueName()).append("\n");
                bodyBuilder.append("Address: ").append(venue.getAddress()).append("\n");
            }
            bodyBuilder.append("\n");
        }

        String body = bodyBuilder.toString();
        
        Email email = Email.builder()
                        .recipient(recipient)
                        .subject(subject)
                        .body(body)
                        .build();
        
        emailService.sendEmail(email);
    }
}
