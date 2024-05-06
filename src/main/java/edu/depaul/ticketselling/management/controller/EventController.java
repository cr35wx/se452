package edu.depaul.ticketselling.management.controller;

import edu.depaul.ticketselling.management.model.Event;
import edu.depaul.ticketselling.management.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    /**
    * The contents were added and modified for the implementation of marketing functions (May 5 2024)
    * src/main/java/edu/depaul/ticketselling/marketing/controller/EventChangeNotificationController.java
    *
    * Please check the annotated comment.
    * @author Suhwan Kim
    */
    private final EventChangeNotificationController eventChangeNotificationController; // Added by Suhwan.

    @Autowired
    public EventController(EventService eventService, 
                        EventChangeNotificationController eventChangeNotificationController) { // Modified by Suhwan.
        this.eventService = eventService;
        this.eventChangeNotificationController = eventChangeNotificationController; // Modified by Suhwan.
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        return eventService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Event> getEventByName(@PathVariable String name) {
        Event event = eventService.findByName(name);
        if (event != null) {
            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/all")
    public ResponseEntity<List<Event>> createAllEvents(@RequestBody List<Event> events) {
        List<Event> createdEvents = eventService.saveAll(events);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvents);
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
        Event updatedEvent = eventService.updateEvent(id, eventDetails);
        if (updatedEvent != null) {
            eventChangeNotificationController.handleEventChangeNotification(updatedEvent, true); // Added by Suhwan.
            return ResponseEntity.ok(updatedEvent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventChangeNotificationController.handleEventDeletionNotification(eventService.findById(id).orElse(null)); // Added by Suhwan.
        eventService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
