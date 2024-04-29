package edu.depaul.ticketselling;

import edu.depaul.ticketselling.management.model.Account;
import edu.depaul.ticketselling.management.model.Event;
import edu.depaul.ticketselling.management.model.Ticket;
import edu.depaul.ticketselling.management.model.Venue;
import edu.depaul.ticketselling.management.service.AccountService;
import edu.depaul.ticketselling.management.service.EventService;
import edu.depaul.ticketselling.management.service.TicketService;
import edu.depaul.ticketselling.management.service.VenueService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
            Venue venue1 = new Venue("The Grand Theatre", "123-456-7890", "info@grandtheatre.com"
                    , 1000,
                    "123 Main St", "Springfield", "IL", "12345", "A historic theater with " +
                    "stunning architecture and modern amenities.");

            Venue venue2 = new Venue("City Music Hall", "987-654-3210", "events@citymusichall" +
                    ".com", 800,
                    "456 Center Ave", "Metropolis", "NY", "54321", "A state-of-the-art concert " +
                    "venue located in the heart of the city.");

            Venue venue3 = new Venue("Lakeview Pavilion", "555-123-4567", "lakeviewpavilion@gmail" +
                    ".com", 300,
                    "789 Lakeside Blvd", "Lakeview", "CA", "67890", "A beautiful outdoor pavilion" +
                    " overlooking the lake, perfect for weddings and events.");

            venueService.saveAll(List.of(venue1, venue2, venue3));
            venue1 = venueService.findByAddress("123 Main St");
            venue2 = venueService.findByAddress("456 Center Ave");
            venue3 = venueService.findByAddress("456 Center Ave");

            Event event1 = new Event("Concert", "John Doe Band",
                    LocalDateTime.of(2024, 5, 15, 20, 0), venue1);

            Event event2 = new Event("Comedy Show", "Laughter Unlimited",
                    LocalDateTime.of(2024, 6, 10, 18, 30), venue2);

            Event event3 = new Event("Art Exhibition", "Creative Minds Gallery",
                    LocalDateTime.of(2024, 7, 5, 10, 0), venue3);

            eventService.saveAll(List.of(event1, event2, event3));
            event1 = eventService.findByName("Concert");
            event2 = eventService.findByName("Comedy Show");
            event3 = eventService.findByName("Art Exhibition");

            System.out.println(venue1 + " " + venue2 + " " + venue3 + " " + event1 + " " + event2 + " " + event3);

            Ticket ticket1 = new Ticket(event1, "A1", 2500); // Seat A1, $25.00
            Ticket ticket2 = new Ticket(event1, "B5", 2000); // Seat B5, $20.00
            Ticket ticket3 = new Ticket(event2, "C3", 1800); // Seat C3, $18.00
            Ticket ticket4 = new Ticket(event3, "D2", 3000); // Seat D2, $30.00

            List<Ticket> tickets = ticketService.saveAll(List.of(ticket1, ticket2, ticket3,
                    ticket4));
            System.out.println(tickets);

            Account account1 = new Account("user1@example.com", "hashedpassword1", "1234567890",
                    LocalDate.now());
            Account account2 = new Account("user2@example.com", "hashedpassword2", "9876543210",
                    LocalDate.now());
            Account account3 = new Account("user3@example.com", "hashedpassword3", "5551234567",
                    LocalDate.now());

            List<Account> accounts = accountService.saveAll(List.of(account1, account2, account3));
            System.out.println(accounts);

            ticket1.setAccount(account1);


        };
    }
}
