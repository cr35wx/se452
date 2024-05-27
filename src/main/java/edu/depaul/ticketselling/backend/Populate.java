package edu.depaul.ticketselling.backend;

import edu.depaul.ticketselling.band.Band;
import edu.depaul.ticketselling.band.BandMember;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Populate {
    public static final List<Venue> VENUES = new ArrayList<>();
    public static final List<Event> EVENTS = new ArrayList<>();
    public static final List<Band> BANDS = new ArrayList<>();
    public static final List<BandMember> BAND_MEMBERS = new ArrayList<>();
    public static final List<Ticket> TICKETS = new ArrayList<>();

    public static List<Ticket> init() {
        return Tickets();
    }

    public static List<Venue> Venues() {
        Venue kresge = Venue.builder().venueName("Kresge Auditorium").seatingCapacity(3917).addressLine1("4000 M-37").city("Interlochen").state("MI").postalCode("49643").build();
        VENUES.add(kresge);

        Venue orchestraHall = Venue.builder().venueName("Orchestra Hall").seatingCapacity(2522).addressLine1("220 S Michigan Ave").city("Chicago").state("IL").postalCode("60604").build();
        VENUES.add(orchestraHall);

        Venue rodgersTheatre = Venue.builder().venueName("Richard Rodgers Theatre").seatingCapacity(1319).addressLine1("226 W 46th Street").city("New York").state("NY").postalCode("10036").build();
        VENUES.add(rodgersTheatre);

        Venue pritzker = Venue.builder().venueName("Pritzker Pavillion").seatingCapacity(11000).addressLine1("201 E Randolph Street").city("Chicago").state("IL").postalCode("60601").build();
        VENUES.add(pritzker);

        Venue gillette = Venue.builder().venueName("Gillette Stadium").seatingCapacity(64628).addressLine1("1 Patriot Place").city("Foxborough").state("MA").postalCode("02035").build();
        VENUES.add(gillette);

        Venue acrisure = Venue.builder().venueName("Acrisure Arena").seatingCapacity(11000).addressLine1("75702 Varner Rd").city("Palm Desert").state("CA").postalCode("92211").build();
        VENUES.add(acrisure);

        Venue lumen = Venue.builder().venueName("Lumen Field").seatingCapacity(68740).addressLine1("800 Occidental Ave S").city("Seattle").state("WA").postalCode("98134").build();
        VENUES.add(lumen);

        Venue capital = Venue.builder().venueName("Capital One Arena").seatingCapacity(20000).addressLine1("601 F Street NW").city("Washington").state("DC").postalCode("20004").build();
        VENUES.add(capital);
        return VENUES;
    }

    public static List<Band> Bands() {
        Band broadwayOnTour = Band.builder().bandName("Broadway on Tour").genre("Theatre").build();
        BandMember broadwayMember = BandMember.builder().memberName("Ensemble").band(broadwayOnTour).build();
        broadwayOnTour.setMembers(List.of(broadwayMember));
        BANDS.add(broadwayOnTour);
        BAND_MEMBERS.add(broadwayMember);

        Band pink = Band.builder().bandName("P!nk").genre("Pop").build();
        BandMember pinkMember = BandMember.builder().memberName("P!nk").band(pink).build();
        pink.setMembers(List.of(pinkMember));
        BANDS.add(pink);
        BAND_MEMBERS.add(pinkMember);

        Band esaPekkaSalonen = Band.builder().bandName("Esa-Pekka Salonen").genre("Classical").build();
        BandMember esaMember = BandMember.builder().memberName("Esa-Pekka Salonen").band(esaPekkaSalonen).build();
        esaPekkaSalonen.setMembers(List.of(esaMember));
        BANDS.add(esaPekkaSalonen);
        BAND_MEMBERS.add(esaMember);

        Band billyJoel = Band.builder().bandName("Billy Joel").genre("Rock").build();
        BandMember billyJoelMember = BandMember.builder().memberName("Billy Joel").band(billyJoel).build();
        billyJoel.setMembers(List.of(billyJoelMember));
        BANDS.add(billyJoel);
        BAND_MEMBERS.add(billyJoelMember);

        Band taylorSwift = Band.builder().bandName("Taylor Swift").genre("Pop").build();
        BandMember taylorSwiftMember = BandMember.builder().memberName("Taylor Swift").band(taylorSwift).build();
        taylorSwift.setMembers(List.of(taylorSwiftMember));
        BANDS.add(taylorSwift);
        BAND_MEMBERS.add(taylorSwiftMember);

        Band riccardoMuti = Band.builder().bandName("Riccardo Muti").genre("Classical").build();
        BandMember riccardoMember = BandMember.builder().memberName("Riccardo Muti").band(riccardoMuti).build();
        riccardoMuti.setMembers(List.of(riccardoMember));
        BANDS.add(riccardoMuti);
        BAND_MEMBERS.add(riccardoMember);

        Band metallica = Band.builder().bandName("Metallica").genre("Metal").build();
        BandMember metallicaMember = BandMember.builder().memberName("Metallica").band(metallica).build();
        metallica.setMembers(List.of(metallicaMember));
        BANDS.add(metallica);
        BAND_MEMBERS.add(metallicaMember);

        Band nsync = Band.builder().bandName("NSYNC").genre("Pop").build();
        BandMember nsyncMember = BandMember.builder().memberName("NSYNC").band(nsync).build();
        nsync.setMembers(List.of(nsyncMember));
        BANDS.add(nsync);
        BAND_MEMBERS.add(nsyncMember);

        Band blueManGroup = Band.builder().bandName("Blue Man Group").genre("Performance Art").build();
        BandMember blueManMember = BandMember.builder().memberName("Blue Man Group").band(blueManGroup).build();
        blueManGroup.setMembers(List.of(blueManMember));
        BANDS.add(blueManGroup);
        BAND_MEMBERS.add(blueManMember);

        Band kateCampbell = Band.builder().bandName("Kate Campbell").genre("Folk").build();
        BandMember kateMember = BandMember.builder().memberName("Kate Campbell").band(kateCampbell).build();
        kateCampbell.setMembers(List.of(kateMember));
        BANDS.add(kateCampbell);
        BAND_MEMBERS.add(kateMember);


        Band band11 = Band.builder().bandName("Band 11").genre("Folk").build();
        BandMember band11Member = BandMember.builder().memberName("Band 11 member").band(band11).build();
        band11.setMembers(List.of(band11Member));
        BANDS.add(band11);
        BAND_MEMBERS.add(band11Member);

        Band band12 = Band.builder().bandName("Band 12").genre("Folk").build();
        BandMember band12Member = BandMember.builder().memberName("Band 12 member").band(band12).build();
        band12.setMembers(List.of(band12Member));
        BANDS.add(band12);
        BAND_MEMBERS.add(band12Member);

        Band band13 = Band.builder().bandName("Band 13").genre("Folk").build();
        BandMember band13Member = BandMember.builder().memberName("Band 13 member").band(band13).build();
        band13.setMembers(List.of(band13Member));
        BANDS.add(band13);
        BAND_MEMBERS.add(band13Member);

        Band band14 = Band.builder().bandName("Band 14").genre("Folk").build();
        BandMember band14Member = BandMember.builder().memberName("Band 14 member").band(band14).build();
        band14.setMembers(List.of(band14Member));
        BANDS.add(band14);
        BAND_MEMBERS.add(band14Member);


        Band band15 = Band.builder().bandName("Band 15").genre("Folk").build();
        BandMember band15Member = BandMember.builder().memberName("Band 15 member").band(band15).build();
        band15.setMembers(List.of(band15Member));
        BANDS.add(band15);
        BAND_MEMBERS.add(band15Member);

        Band band16 = Band.builder().bandName("Band 16").genre("Folk").build();
        BandMember band16Member = BandMember.builder().memberName("Band 16 member").band(band16).build();
        band16.setMembers(List.of(band16Member));
        BANDS.add(band16);
        BAND_MEMBERS.add(band16Member);
        return BANDS;

    }

    public static List<Event> Events() {
        Venues();
        Bands();

        Event e0 = Event.builder()
                .eventName("Wicked")
                .artist(BANDS.get(0))
                .dateTime(LocalDateTime.of(2024, 6, 14, 15, 0))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e0);

        Event e1 = Event.builder()
                .eventName("Hamilton")
                .artist(BANDS.get(1))
                .dateTime(LocalDateTime.of(2024, 8, 21, 21, 30))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e1);

        Event e2 = Event.builder()
                .eventName("P!nk")
                .artist(BANDS.get(2))
                .dateTime(LocalDateTime.of(2024, 8, 21, 21, 30))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e2);

        Event e3 = Event.builder()
                .eventName("New York Philharmonic")
                .artist(BANDS.get(3))
                .dateTime(LocalDateTime.of(2024, 7, 16, 19, 0))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e3);

        Event e4 = Event.builder()
                .eventName("Billy Joel")
                .artist(BANDS.get(4))
                .dateTime(LocalDateTime.of(2024, 6, 21, 20, 30))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e4);

        Event e5 = Event.builder()
                .eventName("Taylor Swift Fearless Tour")
                .artist(BANDS.get(5))
                .dateTime(LocalDateTime.of(2024, 7, 8, 18, 30))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e5);

        Event e6 = Event.builder()
                .eventName("Vienna Philharmonic")
                .artist(BANDS.get(6))
                .dateTime(LocalDateTime.of(2024, 6, 18, 18, 0))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e6);

        Event e7 = Event.builder()
                .eventName("Metallica")
                .artist(BANDS.get(7))
                .dateTime(LocalDateTime.of(2024, 9, 1, 22, 45))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e7);

        Event e8 = Event.builder()
                .eventName("NSYNC")
                .artist(BANDS.get(8))
                .dateTime(LocalDateTime.of(2024, 9, 1, 21, 0))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e8);

        Event e9 = Event.builder()
                .eventName("Blue Man Group")
                .artist(BANDS.get(9))
                .dateTime(LocalDateTime.of(2024, 10, 30, 16, 30))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(e9);

        Event ea = Event.builder()
                .eventName("Kate Campbell")
                .artist(BANDS.get(10))
                .dateTime(LocalDateTime.of(2024, 10, 29, 18, 30))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(ea);

        Event eb = Event.builder()
                .eventName("Frozen")
                .artist(BANDS.get(11))
                .dateTime(LocalDateTime.of(2024, 4, 20, 20, 0))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(eb);

        Event ec = Event.builder()
                .eventName("Taylor Swift Eras Tour")
                .artist(BANDS.get(12))
                .dateTime(LocalDateTime.of(2024, 4, 20, 21, 30))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(ec);

        Event ed = Event.builder()
                .eventName("Kids Night")
                .artist(BANDS.get(13))
                .dateTime(LocalDateTime.of(2024, 5, 17, 20, 30))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(ed);

        Event ee = Event.builder()
                .eventName("Chicago Symphony Orchestra")
                .artist(BANDS.get(14))
                .dateTime(LocalDateTime.of(2024, 5, 30, 21, 30))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(ee);

        Event ef = Event.builder()
                .eventName("BlackPink")
                .artist(BANDS.get(15))
                .dateTime(LocalDateTime.of(2024, 6, 19, 12, 0))
                .venue(VENUES.get(ThreadLocalRandom.current().nextInt(0, VENUES.size())))
                .build();
        EVENTS.add(ef);

        return EVENTS;
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
