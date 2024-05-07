package edu.depaul.ticketselling.backend;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class VenueRepositoryTest {
//    @Autowired
//    private VenueService venueService;

    public static void main(String[] args) {
        SpringApplication.run(VenueRepositoryTest.class, args);
    }

    @Bean
    @Transactional
    CommandLineRunner run(VenueService venueService) {
        return args -> {
            List<Venue> venues = Populate.Venues();

            System.out.println("************Venues************");
            venues.forEach(System.out::println);
            System.out.println("************Venues************\r\n");

            venueService.saveAll(venues);

            List<Venue> allVenues = venueService.findAll();

            System.out.println("A list of all Venues, queried from the database:");
            allVenues.forEach(System.out::println);

        };
    }
}
