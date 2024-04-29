package edu.depaul.ticketselling.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

public class VenueRepositoryTest {
    @Autowired
    private VenueService venueService;

    public static void main(String[] args) {
        SpringApplication.run(VenueRepositoryTest.class, args);
    }

    @Bean
    CommandLineRunner run() {
        return args -> {
            List<Venue> venues = Populate.VENUES;

            System.out.println("Venues:");
            venues.forEach(System.out::println);

            venueService.saveAll(venues);

            List<Venue> allVenues = venueService.findAll();

            System.out.println("A list of all Venues, queried from the database:");
            allVenues.forEach(System.out::println);

        };
    }
}
