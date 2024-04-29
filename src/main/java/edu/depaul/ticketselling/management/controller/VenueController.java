package edu.depaul.ticketselling.management.controller;

import edu.depaul.ticketselling.management.model.Venue;
import edu.depaul.ticketselling.management.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return venueService.findById(id).orElse(null);
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
    public Venue addVenue(@RequestBody Venue venue) {
        return venueService.save(venue);
    }

    @PutMapping("/{id}")
    public Venue updateVenue(@PathVariable Long id, @RequestBody Venue venue) {
        if (!venueService.findById(id).isPresent()) {
            return null; // Venue not found
        }
        venue.setId(id);
        return updateVenue(id, venue);
    }

    @DeleteMapping("/{id}")
    public void deleteVenueById(@PathVariable Long id) {
        venueService.deleteById(id);
    }

    // Additional endpoints for venue availability, search, validation, etc.
}