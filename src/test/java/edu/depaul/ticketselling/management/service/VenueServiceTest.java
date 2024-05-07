package edu.depaul.ticketselling.management.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import edu.depaul.ticketselling.backend.IVenueRepository;
import edu.depaul.ticketselling.backend.Venue;
import edu.depaul.ticketselling.backend.VenueService;

public class VenueServiceTest {

    @Mock
    private IVenueRepository venueRepository;

    @InjectMocks
    private VenueService venueService;

    @SuppressWarnings("deprecation")
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Given
        List<Venue> venues = Arrays.asList(new Venue(), new Venue());
        when(venueRepository.findAll()).thenReturn(venues);

        // When
        List<Venue> result = venueService.findAll();

        // Then
        assertEquals(venues.size(), result.size());
        verify(venueRepository, times(1)).findAll();
    }

    // Add more tests for other methods as needed
}
