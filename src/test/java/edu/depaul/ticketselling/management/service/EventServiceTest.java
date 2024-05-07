package edu.depaul.ticketselling.management.service;

import edu.depaul.ticketselling.backend.IEventRepository;
import edu.depaul.ticketselling.backend.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EventServiceTest {

    @Mock
    private IEventRepository eventRepository;

    @InjectMocks
    private EventService eventService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllEvents() {
        // Given
        List<Event> events = Arrays.asList(new Event(), new Event());
        when(eventRepository.findAll()).thenReturn(events);

        // When
        List<Event> result = eventService.findAllEvents();

        // Then
        assertEquals(events.size(), result.size());
        verify(eventRepository, times(1)).findAll();
    }

}