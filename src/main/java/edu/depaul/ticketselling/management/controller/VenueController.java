package edu.depaul.ticketselling.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.ticketselling.backend.Venue;
import edu.depaul.ticketselling.backend.VenueService;

@RestController
@RequestMapping("/venues")
public class VenueController {

    private final VenueService venueService;

    @Autowired
    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping("/{id}")
    public Venue getVenueById(@PathVariable Long id) {
        return venueService.findByVenueId(id);
    }

    @GetMapping("/address/{address}")
    public Venue getVenueByAddress(@PathVariable String address) {
        return venueService.findByAddress(address);
    }

    @GetMapping
    public List<Venue> getAllVenues() {
        return venueService.findAll();
    }

    @PostMapping
    public void addVenue(@RequestBody Venue venue) {
        venueService.save(venue);
    }

//    @PutMapping("/{id}")
//    public Venue updateVenue(@PathVariable Long id, @RequestBody Venue venue) {
//        if (!venueService.findByVenueId(id).isPresent()) {
//            return null; // Venue not found
//        }
//        venue.setVenueId(id);
//        return updateVenue(id, venue);
//    }

    @DeleteMapping("/{id}")
    public void deleteVenueById(@PathVariable Long id) {
        venueService.deleteById(id);
    }

    // Additional endpoints for venue availability, search, validation, etc.
}
