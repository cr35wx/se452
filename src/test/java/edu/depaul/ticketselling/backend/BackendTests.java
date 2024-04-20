package edu.depaul.ticketselling.backend;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class BackendTests {
    @Test
    public void VenueToStringTest() {
        Venue.Address addr = Venue.Address.builder().line1("4000 M-37").city("Interlochen").state("MI").postalCode("49643").build();
        Venue stage = Venue.builder().venueId(100).venueName("Kresge Auditorium").address(addr).seatingCapacity(3900).build();

        System.out.println(addr.toString());
        System.out.println();
        System.out.println(stage.toString());
        System.out.println();

        Venue.Address addr2 = Venue.Address.builder().line1("285 N West Street").line2("Lot 3").city("Nowhere").state("AZ").postalCode("80515").build();
        Venue stage2 = Venue.builder().venueId(100).venueName("Cool Place").address(addr2).seatingCapacity(2500).build();

        System.out.println(addr2.toString());
        System.out.println();
        System.out.println(stage2.toString());
    }

    @Test
    public void EventToStringTest() {
        LocalDateTime date = LocalDateTime.of(2024, 8, 21, 21, 30);
        Venue.Address addr = Venue.Address.builder().line1("226 W 46th Street").city("New York").state("NY").postalCode("10036").build();
        Venue stage = Venue.builder().venueId(100).venueName("Richard Rodgers Theatre").address(addr).seatingCapacity(3900).build();
        Event ev = Event.builder().eventId(20635).eventName("Hamilton").artist("Broadway on Tour").dateTime(date).venue(stage).build();

        System.out.println(ev.toString());
        System.out.println();
    }

    @Test
    public void TicketToStringTest() {
        LocalDateTime date = LocalDateTime.of(2024, 8, 21, 21, 30);
        Venue.Address addr = Venue.Address.builder().line1("226 W 46th Street").city("New York").state("NY").postalCode("10036").build();
        Venue stage = Venue.builder().venueId(100).venueName("Richard Rodgers Theatre").address(addr).seatingCapacity(3900).build();
        Event ev = Event.builder().eventId(20635).eventName("Hamilton").artist("Broadway on Tour").dateTime(date).venue(stage).build();
        Ticket t = Ticket.builder().ticketId(505584).seatNumber(21).event(ev).price(115295).build();

        System.out.println(t);
    }

    @Test
    public void UserToStringTest() {
        User user = new Customer(109558, "wberthouex", "hashedpassword", "wberthou@depaul.edu", "555-555-5555", LocalDateTime.now());
        System.out.println(user);
        System.out.println();

        User admn = new Admin(109559, "wberthouex", "hashedpassword2", "wberthou@email.com", "+55 125369125", LocalDateTime.now());
        System.out.println(admn);
    }

}
