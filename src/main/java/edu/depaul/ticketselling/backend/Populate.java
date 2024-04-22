package edu.depaul.ticketselling.backend;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class generates a set of {@link Venue}s, {@link Event}s, and {@link Ticket}s.<p>
 * These objects can be accessed with the public class variables {@code VENUES}, {@code EVENTS}, and {@code TICKETS}.
 * Each variable is a {@link List}.
 */
public class Populate {
    public static final List<Venue> VENUES = new ArrayList<>();
    public static final List<Event> EVENTS = new ArrayList<>();
    public static final List<Ticket> TICKETS = new ArrayList<>();

    /**
     * Initialize the class using this method to populate all the public class variables.
     * @return a {@code List} of {@link Ticket}s
     */
    public static List<Ticket> init() {
        return Tickets();
    }

    protected static void Venues() {
        Venue.Address a1 = Venue.Address.builder().line1("4000 M-37").city("Interlochen").state("MI").postalCode("49643").build();
        Venue kresge = Venue.builder().venueName("Kresge Auditorium").address(a1).seatingCapacity(3917).build();
        VENUES.add(kresge);

        Venue.Address a2 = Venue.Address.builder().line1("220 S Michigan Ave").city("Chicago").state("IL").postalCode("60604").build();
        Venue orchestraHall = Venue.builder().venueName("Orchestra Hall").address(a2).seatingCapacity(2522).build();
        VENUES.add(orchestraHall);

        Venue.Address a3 = Venue.Address.builder().line1("226 W 46th Street").city("New York").state("NY").postalCode("10036").build();
        Venue rodgersTheatre = Venue.builder().venueName("Richard Rodgers Theatre").address(a3).seatingCapacity(1319).build();
        VENUES.add(rodgersTheatre);

        Venue.Address a4 = Venue.Address.builder().line1("201 E Randolph Street").city("Chicago").state("IL").postalCode("60601").build();
        Venue pritzker = Venue.builder().venueName("Pritzker Pavillion").address(a4).seatingCapacity(11000).build();
        VENUES.add(pritzker);

        Venue.Address a5 = Venue.Address.builder().line1("1 Patriot Place").city("Foxborough").state("MA").postalCode("02035").build();
        Venue gillette = Venue.builder().venueName("Gillette Stadium").address(a5).seatingCapacity(64628).build();
        VENUES.add(gillette);

        Venue.Address a6 = Venue.Address.builder().line1("75702 Varner Rd").city("Palm Desert").state("CA").postalCode("92211").build();
        Venue acrisure = Venue.builder().venueName("Acrisure Arena").address(a6).seatingCapacity(11000).build();
        VENUES.add(acrisure);

        Venue.Address a7 = Venue.Address.builder().line1("800 Occidental Ave S").city("Seattle").state("WA").postalCode("98134").build();
        Venue lumen = Venue.builder().venueName("Lumen Field").address(a7).seatingCapacity(68740).build();
        VENUES.add(lumen);

        Venue.Address a8 = Venue.Address.builder().line1("601 F Street NW").city("Washington").state("DC").postalCode("20004").build();
        Venue capital = Venue.builder().venueName("Capital One Arena").address(a8).seatingCapacity(20000).build();
        VENUES.add(capital);
    }

    protected static void Events() {
        Venues();
        Event e0 = Event.builder()
                .eventName("Wicked")
                .artist("Broadway on Tour")
                .dateTime(LocalDateTime.of(2024, 6, 14, 15, 0))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e0);

        Event e1 = Event.builder()
                .eventName("Hamilton")
                .artist("Broadway on Tour")
                .dateTime(LocalDateTime.of(2024, 8, 21, 21, 30))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e1);

        Event e2 = Event.builder()
                .eventName("P!nk")
                .artist("P!nk")
                .dateTime(LocalDateTime.of(2024, 8, 21, 21, 30))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e2);

        Event e3 = Event.builder()
                .eventName("New York Philharmonic")
                .artist("Esa-Pekka Salonen")
                .dateTime(LocalDateTime.of(2024, 7, 16, 19, 0))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e3);

        Event e4 = Event.builder()
                .eventName("Billy Joel")
                .artist("Billy Joel")
                .dateTime(LocalDateTime.of(2024, 6, 21, 20, 30))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e4);

        Event e5 = Event.builder()
                .eventName("Taylor Swift Fearless Tour")
                .artist("Taylor Swift")
                .dateTime(LocalDateTime.of(2024, 7, 8, 18, 30))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e5);

        Event e6 = Event.builder()
                .eventName("Chicago Symphony Orchestra")
                .artist("Riccardo Muti")
                .dateTime(LocalDateTime.of(2024, 6, 18, 18, 0))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e6);

        Event e7 = Event.builder()
                .eventName("Metallica")
                .artist("Metallica")
                .dateTime(LocalDateTime.of(2024, 9, 1, 22, 45))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e7);

        Event e8 = Event.builder()
                .eventName("NSYNC")
                .artist("NSYNC")
                .dateTime(LocalDateTime.of(2024, 9, 1, 21, 0))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e8);

        Event e9 = Event.builder()
                .eventName("Blue Man Group")
                .artist("Blue Man Group")
                .dateTime(LocalDateTime.of(2024, 10, 30, 16, 30))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e9);

        Event ea = Event.builder()
                .eventName("Kate Campbell")
                .artist("Kate Campbell")
                .dateTime(LocalDateTime.of(2024, 10, 29, 18, 30))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(ea);

        Event eb = Event.builder()
                .eventName("Wicked")
                .artist("Broadway on Tour")
                .dateTime(LocalDateTime.of(2024, 4, 20, 20, 0))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(eb);

        Event ec = Event.builder()
                .eventName("Taylor Swift Eras Tour")
                .artist("Taylor Swift")
                .dateTime(LocalDateTime.of(2024, 4, 20, 21, 30))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(ec);

        Event ed = Event.builder()
                .eventName("Kids Night")
                .artist("Blue Man Group")
                .dateTime(LocalDateTime.of(2024, 5, 17, 20, 30))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(ed);

        Event ee = Event.builder()
                .eventName("Chicago Symphony Orchestra")
                .artist("Esa-Pekka Salonen")
                .dateTime(LocalDateTime.of(2024, 5, 30, 21, 30))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(ee);

        Event ef = Event.builder()
                .eventName("BlackPink")
                .artist("BlackPink")
                .dateTime(LocalDateTime.of(2024, 6, 19, 12, 0))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(ef);
    }

    public static List<Ticket> Tickets() {
        Events();

        for (int i = 0; i < 16; i++) {
            Ticket t = Ticket.builder()
                    .seatNumber(ThreadLocalRandom.current().nextInt(1, 1200))
                    .event(EVENTS.get(ThreadLocalRandom.current().nextInt(0, EVENTS.size())))
                    .price(ThreadLocalRandom.current().nextInt(1, 25600))
                    .build();
            TICKETS.add(t);
        }

        return TICKETS;
    }

    private Populate() {
        ;
    }
}