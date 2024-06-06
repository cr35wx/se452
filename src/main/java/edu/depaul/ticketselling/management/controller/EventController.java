package edu.depaul.ticketselling.management.controller;

import edu.depaul.ticketselling.backend.Event;
import edu.depaul.ticketselling.management.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import edu.depaul.ticketselling.marketing.controller.EventChangeNotificationController;
import edu.depaul.ticketselling.marketing.controller.EventCancelNotificationController;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    private EventChangeNotificationController eventChangeNoti;
    private EventCancelNotificationController eventCancelNoti; // Added

    @Autowired
    public EventController(EventService eventService,
                        EventChangeNotificationController eventChangeNoti,
                        EventCancelNotificationController eventCancelNoti) {
        this.eventService = eventService;
        this.eventChangeNoti = eventChangeNoti; // Added
        this.eventCancelNoti = eventCancelNoti; // Added
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.findAllEvents();
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
        List<Event> createdEvents = StreamSupport.stream(eventService.saveAll(events).spliterator(), false)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvents);
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    /**
     * Additional functionality for the Event Change and Cancel Notification Mail Send function.
     * 
     * @param eventChangeNoti Event Change Notification Mail Send function. 
     * Added this feature to updateEvent, please check it.
     * 
     * @author Suhwan Kim
     */
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
        Event updatedEvent = eventService.updateEvent(id, eventDetails);
        if (updatedEvent != null) {
            eventChangeNoti.handleEventChangeNotification(updatedEvent, true); // Added
            return ResponseEntity.ok(updatedEvent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteById(id);
        eventCancelNoti.handleEventCancellationNotification(id); // Added
        return ResponseEntity.noContent().build();
    }
}
