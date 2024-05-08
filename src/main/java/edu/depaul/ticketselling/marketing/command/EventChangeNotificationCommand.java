package edu.depaul.ticketselling.marketing.command;

import edu.depaul.ticketselling.backend.Event;
import edu.depaul.ticketselling.backend.IVenueRepository;
import edu.depaul.ticketselling.backend.Venue;
import edu.depaul.ticketselling.marketing.service.Email;
import edu.depaul.ticketselling.marketing.service.EmailService;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * [Marketing and communication]
 * This code is Event changes.
 * 
 * This command is responsible for executing notifications related to event changes.
 * It interacts with the EmailService to send out the notifications.
 * 
 * Upon execution, it determines whether the event has been updated or deleted based on the provided flag.
 * It constructs the appropriate notification email content and utilizes the EmailService to send the email.
 * 
 * @author Suhwan Kim
 */
@RestController
@RequestMapping("/email")
@Component
public class EventChangeNotificationCommand {
    private final EmailService emailService;
    private final IVenueRepository venueRepository;

    /**
     * Constructor for EventChangeNotificationCommand.
     * 
     * @param emailService The service responsible for sending emails.
     */
    public EventChangeNotificationCommand(EmailService emailService, 
                                     IVenueRepository venueRepository) {
        this.emailService = emailService;
        this.venueRepository = venueRepository;
    }

    /**
     * Sends a notification for event updates.
     * 
     * @param recipient The email address of the recipient.
     * @param event     The updated event information.
     * @param isUpdated A flag indicating if the event has been updated.
     */
    public void execute(String recipient, Event event) {
        String subject = "Event Change Notification";
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("<html><body>");
        bodyBuilder.append("<p>Dear customer,</p><br>");
        bodyBuilder.append("<p>The event you have purchased tickets for has been changed.</p><br>");
        bodyBuilder.append("<p>Event: ").append(event.getEventName()).append("</p>");
        bodyBuilder.append("<p>Artist: ").append(event.getArtist()).append("</p>");
        bodyBuilder.append("<p>Date and Time: ").append(event.getDateTime()).append("</p>");
        bodyBuilder.append("<p>Please check the updated details.</p><br>");

        Venue venue = venueRepository.findById(event.getVenue().getVenueId());
        bodyBuilder.append("<p>Venue: ").append(venue.getVenueName()).append("</p>");
        bodyBuilder.append("<p>Address: ").append(venue.getAddress()).append("</p>");
    
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
