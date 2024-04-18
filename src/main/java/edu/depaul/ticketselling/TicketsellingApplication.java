package edu.depaul.ticketselling;

import edu.depaul.ticketselling.management.model.Event;
import edu.depaul.ticketselling.management.model.Ticket;
import edu.depaul.ticketselling.management.service.EventService;
import edu.depaul.ticketselling.management.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class TicketsellingApplication {

	@Autowired
	private TicketService ticketService;

	@Autowired
	private EventService eventService;

	public static void main(String[] args) {
		SpringApplication.run(TicketsellingApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			// This is an example of using the models.
			// relationships are not implemented yet so there are magic numbers for id's

			//TODO autoincrementing id's are not generating here, but are fine if you check the db
			List<Ticket> tickets = List.of(
					new Ticket(1L, 101L, new BigDecimal("50.00"), "A101"),
					new Ticket(1L, 102L, new BigDecimal("50.00"), "A102"),
					new Ticket(2L, 103L, new BigDecimal("60.00"), "B101"),
					new Ticket(2L, 104L, new BigDecimal("60.00"), "B102"),
					new Ticket(3L, 105L, new BigDecimal("70.00"), "C101")
			);

			System.out.println("Newly created tickets:");
			tickets.forEach(System.out::println);

			ticketService.saveAll(tickets);

			List<Ticket> ticketsWithEventId1 = ticketService.findTicketsByEventId(1L);
			System.out.println(ticketsWithEventId1);

			List<Ticket> allTickets = ticketService.findAll();

			System.out.println("A list of all tickets, queried from the database:");
			allTickets.forEach(System.out::println);


			List<Event> events = List.of(
					// generic names
					new Event("Concert", LocalDate.of(2024, 5, 15)),
					new Event("Sports Event", LocalDate.of(2024, 6, 20)),
					new Event("Conference", LocalDate.of(2024, 7, 25))
			);

			System.out.println("Newly created events:");
			events.forEach(System.out::println);

			eventService.saveAll(events);

			List<Event> allEvents = eventService.getAllEvents();

			System.out.println("A list of all events, queried from the database:");
			System.out.println(allEvents);

		};
	}
}
