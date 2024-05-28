package edu.depaul.ticketselling.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDateTime;
import java.util.List;

import edu.depaul.ticketselling.band.Band;
import edu.depaul.ticketselling.band.BandMember;
import org.junit.jupiter.api.Test;

public class BackendTests {

    @Test
    public void VenueToStringTest() {
        String addrLine11 = "226 W 46th Street";
        String city1 = "New York";
        String state1 = "NY";
        String zip1 = "10036";

        String venue1 = "Richard Rodgers Theatre";
        int cap1 = 3900;
        int id1 = 100;

        Venue stage1 = Venue.builder().venueId(id1).venueName(venue1).seatingCapacity(cap1).addressLine1(addrLine11).city(city1).state(state1).postalCode(zip1).build();

        System.out.println(stage1.toString());
        System.out.println();

        String addr1 = String.format("%s%n%s, %s %s", addrLine11, city1, state1, zip1);

        String expected1 = String.format("%s%n%s%nVenue ID: %d, Seating capacity: %d",
                venue1,
                addr1,
                id1,
                cap1
        );

        assertEquals(expected1, stage1.toString());
        assertNotEquals("fail", stage1.toString());

        String addrLine12 = "226 W 46th Street";
        String addrLine2 = "Lot 3";
        String city2 = "New York";
        String state2 = "NY";
        String zip2 = "10036";

        String venue2 = "Richard Rodgers Theatre";
        int cap2 = 3900;
        int id2 = 102;

        Venue stage2 = Venue.builder().venueId(id2).venueName(venue2).seatingCapacity(cap2).addressLine1(addrLine12).addressLine2(addrLine2).city(city2).state(state2).postalCode(zip2).build();

        System.out.println(stage2.toString());

        String addr2 = String.format("%s%n%s%n%s, %s %s", addrLine12, addrLine2, city2, state2, zip2);

        String expected2 = String.format("%s%n%s%nVenue ID: %d, Seating capacity: %d",
                venue2,
                addr2.toString(),
                id2,
                cap2
        );

        System.out.println(expected2);

        assertEquals(expected2, stage2.toString());
        assertNotEquals("fail", stage2.toString());
    }

    @Test
    public void EventToStringTest() {
        String addrLine1 = "226 W 46th Street";
        String city = "New York";
        String state = "NY";
        String zip = "10036";

        String venueName = "Richard Rodgers Theatre";
        int cap = 3900;

        String eventName = "Hamilton";
        Band artist = Band.builder().bandName("Broadway on Tour").genre("Theatre").build();
        BandMember broadwayMember = BandMember.builder().memberName("Ensemble").band(artist).build();
        artist.setMembers(List.of(broadwayMember));

        LocalDateTime date = LocalDateTime.of(2024, 8, 21, 21, 30);
        Venue stage = Venue.builder().venueId(100).venueName(venueName).seatingCapacity(cap).addressLine1(addrLine1).city(city).state(state).postalCode(zip).build();
        Event ev = Event.builder().eventId(20635).eventName(eventName).artist(artist).dateTime(date).venue(stage).build();

        System.out.println(ev.toString());
        System.out.println();

        String addr = String.format("%s%n%s, %s %s", addrLine1, city, state, zip);

        String expected = String.format("%s%n%s%n%s at %s%n%s%n%s",
                eventName,
                artist,
                date.toLocalDate().toString(),
                date.toLocalTime().toString(),
                venueName,
                addr
        );

        assertEquals(expected, ev.toString());
        assertNotEquals("fail", ev.toString());
    }

    @Test
    public void TicketToStringTest() {
        String addrLine1 = "226 W 46th Street";
        String city = "New York";
        String state = "NY";
        String zip = "10036";

        String venueName = "Richard Rodgers Theatre";
        int cap = 3900;

        String eventName = "Hamilton";
        Band artist = Band.builder().bandName("Broadway on Tour").genre("Theatre").build();
        BandMember broadwayMember = BandMember.builder().memberName("Ensemble").band(artist).build();
        artist.setMembers(List.of(broadwayMember));

        int seatNo = 21;
        int price = 115295;
        int id = 505584;

        LocalDateTime date = LocalDateTime.of(2024, 8, 21, 21, 30);
        Venue stage = Venue.builder().venueId(100).venueName(venueName).seatingCapacity(cap).addressLine1(addrLine1).city(city).state(state).postalCode(zip).build();
        Event ev = Event.builder().eventId(20635).eventName(eventName).artist(artist).dateTime(date).venue(stage).build();
        Ticket t = Ticket.builder().ticketId(id).seatNumber(seatNo).event(ev).price(price).build();

        System.out.println(t);

        String addr = String.format("%s%n%s, %s %s", addrLine1, city, state, zip);

        String expected = String.format(
                "%s%n%s at %s, seat %d%n%s%n%s%nPrice: $%,.2f\tTicket number: %d",
                eventName,
                date.toLocalDate().toString(),
                date.toLocalTime().toString(),
                seatNo,
                venueName,
                addr,
                (float) (price / 100),
                id
        );

        assertEquals(expected, t.toString());
        assertNotEquals("fail", t.toString());
    }

    @Test
    public void UserToStringTest() {
        String pass1 = "hashedpassword";
        String e1 = "wberthou@depaul.edu";
        String p1 = "555-555-5555";
        LocalDateTime date = LocalDateTime.now();

        int id1 = 109558;

        User user = new Customer(id1, e1, pass1, p1, date);
        System.out.println(user);
        System.out.println();

        String expected1 = String.format("User ID: %d%nEmail: %s%nPhone: %s",
                id1,
                e1,
                p1
        );

        assertEquals(expected1, user.toString());

        String pass2 = "hashedpassword";
        String e2 = "wberthou@depaul.edu";
        String p2 = "555-555-5555";

        int id2 = 109558;

        User admn = new Admin(id2, e2, pass2, p2, date);
        System.out.println(admn);

        String expected2 = String.format("Administrator, User ID: %d%nEmail: %s%nPhone: %s",
                id2,
                e2,
                p2
        );

        assertEquals(expected2, admn.toString());

        assertNotEquals(user, admn);
    }

}
