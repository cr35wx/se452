package edu.depaul.ticketselling;

import edu.depaul.ticketselling.backend.*;
import edu.depaul.ticketselling.band.Band;
import edu.depaul.ticketselling.band.BandMember;
import edu.depaul.ticketselling.band.BandMemberService;
import edu.depaul.ticketselling.band.BandService;
import edu.depaul.ticketselling.management.service.*;
import edu.depaul.ticketselling.marketing.controller.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class TicketsellingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketsellingApplication.class, args);
    }

    @Bean
    @Transactional
    CommandLineRunner runner(VenueService venueService,
                             EventService eventService,
                             TicketService ticketService,
                             AccountService accountService,
                             BandService bandService,
                             BandMemberService bandMemberService,
                             OnSaleNotificationController onSaleNotificationController,
                             OrderConfirmationController orderConfirmationController,
                             EventReminderController eventReminderController, 
                             EventChangeNotificationController eventChangeNotificationController,
                             EventCancelNotificationController eventCancelNotificationController) {
        return args -> {
            // create venues first, then events, then tickets to go to those events, then
            // accounts, and give some tickets to those accounts
//            Venue venue1 = new Venue("The Grand Theatre", "123-456-7890", "info@grandtheatre.com"
//                    , 1000,
//                    "123 Main St", "Springfield", "IL", "12345", "A historic theater with " +
//                    "stunning architecture and modern amenities.");
//
//            Venue venue2 = new Venue("City Music Hall", "987-654-3210", "events@citymusichall" +
//                    ".com", 800,
//                    "456 Center Ave", "Metropolis", "NY", "54321", "A state-of-the-art concert " +
//                    "venue located in the heart of the city.");
//
//            Venue venue3 = new Venue("Lakeview Pavilion", "555-123-4567", "lakeviewpavilion@gmail" +
//                    ".com", 300,
//                    "789 Lakeside Blvd", "Lakeview", "CA", "67890", "A beautiful outdoor pavilion" +
//                    " overlooking the lake, perfect for weddings and events.");

            // Populate lists. Order is important
            List<Ticket> tickets = Populate.Tickets();
            List<Event> events = Populate.EVENTS;
            List<Venue> venues = Populate.VENUES;
            List<Band> bands = Populate.BANDS;
            List<BandMember> bandMembers = Populate.BAND_MEMBERS;

            venueService.saveAll(venues);
            Venue venue1 = venueService.findByAddress("220 S Michigan Ave");
            Venue venue2 = venueService.findByAddress("201 E Randolph Street");
            Venue venue3 = venueService.findByAddress("800 Occidental Ave S");

            bandService.saveAll(bands);
            bandMemberService.saveAll(bandMembers);

            eventService.saveAll(events);
            Event event1 = eventService.findByName("Wicked");
            Event event2 = eventService.findByName("Hamilton");
            Event event3 = eventService.findByName("New York Philharmonic");

            System.out.println(venue1);
            System.out.println(venue2);
            System.out.println(venue3);
            System.out.println(event1);
            System.out.println(event2);
            System.out.println(event3);

//            Ticket ticket1 = new Ticket(event1, 1, 2500); // Seat A1, $25.00
//            Ticket ticket2 = new Ticket(event1, 5, 2000); // Seat B5, $20.00
//            Ticket ticket3 = new Ticket(event2, 3, 1800); // Seat C3, $18.00
//            Ticket ticket4 = new Ticket(event3, 2, 3000); // Seat D2, $30.00

            ticketService.saveAll(tickets);
            System.out.println(tickets);

            User account1 = new Customer(1, "shkim901101@naver.com", "hashedpassword1", "1234567890", LocalDateTime.now());
            User account2 = new Customer(2, "user2@example.com", "hashedpassword2", "9876543210", LocalDateTime.now());
            User account3 = new Customer(3, "user3@example.com", "hashedpassword3", "5551234567", LocalDateTime.now());

            List<User> accounts = new ArrayList<>();
            Iterable<User> temp = accountService.saveAll(List.of(account1, account2, account3));
            temp.forEach(accounts::add);
            System.out.println(accounts);

            //ticket1.setAccount(account1);
            
            // Test On sale Notification
            // onSaleNotificationController.sendOnSaleNotificationEmails();
            
            // Test Order Confirmation
            //     Purchase purchase1 = new Purchase();
            //     purchase1.setTicket(ticket1);
            //     purchase1.setEvent(event1);
            //     purchase1.setVenue(event1.getVenue());
            //     purchase1.setAccount(account1);
            //     purchaseService.save(purchase1);
            
            // orderConfirmationController.confirmOrder(purchase1);

            // Test Reminder
            // eventReminderController.sendEventReminderEmails();

            // Event Change/Cancel Notification
            // eventChangeNotificationController.handleEventChangeNotification(event1, true);
            // eventCancelNotificationController.handleEventCancellationNotification(event1.getEventId());
        };
    }
}
