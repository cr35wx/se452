package edu.depaul.ticketselling.management.service;

import edu.depaul.ticketselling.management.model.Venue;
import edu.depaul.ticketselling.management.repository.VenueRepository;
import edu.depaul.ticketselling.management.service.VenueService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VenueServiceTest {

    @Mock
    private VenueRepository venueRepository;

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
