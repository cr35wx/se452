package edu.depaul.ticketselling;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import edu.depaul.ticketselling.backend.Customer;
import edu.depaul.ticketselling.backend.Event;
import edu.depaul.ticketselling.backend.Populate;
import edu.depaul.ticketselling.backend.Ticket;
import edu.depaul.ticketselling.backend.User;
import edu.depaul.ticketselling.backend.Venue;
import edu.depaul.ticketselling.backend.VenueService;
import edu.depaul.ticketselling.management.service.AccountService;
import edu.depaul.ticketselling.management.service.EventService;
import edu.depaul.ticketselling.management.service.TicketService;

@SpringBootApplication
public class TicketsellingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketsellingApplication.class, args);
    }

    @Bean
    @Transactional
    CommandLineRunner runner(VenueService venueService, EventService eventService,
                             TicketService ticketService, AccountService accountService) {
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

            venueService.saveAll(venues);
            Venue venue1 = venueService.findByAddress("220 S Michigan Ave");
            Venue venue2 = venueService.findByAddress("201 E Randolph Street");
            Venue venue3 = venueService.findByAddress("800 Occidental Ave S");

//            Event event1 = new Event("Concert", "John Doe Band",
//                    LocalDateTime.of(2024, 5, 15, 20, 0), venue1);
//
//            Event event2 = new Event("Comedy Show", "Laughter Unlimited",
//                    LocalDateTime.of(2024, 6, 10, 18, 30), venue2);
//
//            Event event3 = new Event("Art Exhibition", "Creative Minds Gallery",
//                    LocalDateTime.of(2024, 7, 5, 10, 0), venue3);

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

            User account1 = new Customer(1, "user1@example.com", "hashedpassword1", "1234567890", LocalDateTime.now());
            User account2 = new Customer(2, "user2@example.com", "hashedpassword2", "9876543210", LocalDateTime.now());
            User account3 = new Customer(3, "user3@example.com", "hashedpassword3", "5551234567", LocalDateTime.now());

            List<User> accounts = new ArrayList<>();
            Iterable<User> temp = accountService.saveAll(List.of(account1, account2, account3));
            temp.forEach(accounts::add);
            System.out.println(accounts);

            //ticket1.setAccount(account1);

        };
    }
}
