package edu.depaul.ticketselling.management.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import edu.depaul.ticketselling.management.model.Event;
import edu.depaul.ticketselling.management.repository.EventRepository;
import edu.depaul.ticketselling.management.service.EventService;

@ExtendWith(MockitoExtension.class)
public class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventService eventService;

    @Test
    public void testGetAllEvents() {
        // Mock data
        List<Event> events = new ArrayList<>();
        events.add(new Event(1L, "Concert", LocalDate.of(2024, 5, 15)));
        events.add(new Event(2L, "Sports Event", LocalDate.of(2024, 6, 20)));

        // Stubbing the behavior of eventRepository.findAll() method
        when(eventRepository.findAll()).thenReturn(events);

        // Call the method to be tested
        List<Event> result = eventService.getAllEvents();

        // Verify the result
        assertEquals(2, result.size());
        assertEquals("Concert", result.get(0).getEventName());
        assertEquals("Sports Event", result.get(1).getEventName());
    }

    @Test
    public void testFindEventByEventName() {
        // Mock data
        Event event = new Event(1L, "Concert", LocalDate.of(2024, 5, 15));

        // Stubbing the behavior of eventRepository.findByEventName() method
        when(eventRepository.findByEventName("Concert")).thenReturn(event);

        // Call the method to be tested
        Event result = eventService.findByEventName("Concert");

        // Verify the result
        assertEquals("Concert", result.getEventName());
        assertEquals(LocalDate.of(2024, 5, 15), result.getEventDate());
    }
}
